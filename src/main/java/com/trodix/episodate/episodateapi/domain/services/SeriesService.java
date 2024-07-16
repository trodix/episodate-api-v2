package com.trodix.episodate.episodateapi.domain.services;

import com.trodix.episodate.episodateapi.persistence.entities.SerieLink;
import com.trodix.episodate.episodateapi.persistence.mappers.SerieMapper;
import com.trodix.episodate.episodateapi.persistence.entities.Serie;
import com.trodix.episodate.episodateapi.persistence.mappers.LinkMapper;
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
    private final LinkMapper linkMapper;

    public record SerieLinkQuery(String serieName, Integer season, Integer episode, String episodeName) {}
    public record SerieLinkData(String serieName, String url) {}

    public List<SerieLinkData> getSerieLinks(SerieLinkQuery query) {
        return linkMapper.findLinks(query.serieName).stream().map(link -> toSerieLinkData(query, link)).toList();
    }

    public static SerieLinkData toSerieLinkData(SerieLinkQuery query, SerieLink link) {
        return new SerieLinkData(link.getSerie().getName(), toSerieUrl(link, query));
    }

    public static String toSerieUrl(SerieLink link, SerieLinkQuery query) {

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

    public List<Serie> getAll() {
        return serieMapper.findAll();
    }

    public Serie create(Serie serie) {
        serieMapper.insert(serie);
        return serie;
    }

    public void update(Serie serie) {
        serieMapper.update(serie);
    }

    public void delete(Long id) {
        serieMapper.delete(id);
    }

}
