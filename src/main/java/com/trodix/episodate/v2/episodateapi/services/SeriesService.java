package com.trodix.episodate.v2.episodateapi.services;

import com.trodix.episodate.v2.episodateapi.persistence.entities.SerieLink;
import com.trodix.episodate.v2.episodateapi.persistence.mappers.SerieMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.text.StringSubstitutor;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SeriesService {

    private final SerieMapper serieMapper;

    public record SerieDataQuery(String serieName, Integer season, Integer episode, String episodeName) {}
    public record SerieData(String serieName, String url) {}

    public List<SerieData> getSerieData(SerieDataQuery query) {
        return serieMapper.findLinks(query.serieName).stream().map(link -> toSerieData(query, link)).toList();
    }

    public static SerieData toSerieData(SerieDataQuery query, SerieLink link) {
        return new SerieData(link.getSerieName(), toSerieUrl(link, query));
    }

    public static String toSerieUrl(SerieLink link, SerieDataQuery query) {

        String startDelimiter = "${";
        String endDelimiter = "}";

        Map<String, Serializable> params = new HashMap<>();
        params.put("season", query.season());
        params.put("episode", query.episode());
        params.put("episodeName", query.episodeName());

        String serieUrl = StringSubstitutor.replace(link.getUrlPattern(), params, startDelimiter, endDelimiter);

        try {
            return new URL(serieUrl).toString();
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(MessageFormat.format("Malformed URL: {0}}", serieUrl), e);
        }
    }

}
