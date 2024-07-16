package com.trodix.episodate.episodateapi.domain.services;

import com.trodix.episodate.episodateapi.persistence.entities.Serie;
import com.trodix.episodate.episodateapi.persistence.entities.SerieLink;
import com.trodix.episodate.episodateapi.persistence.mappers.LinkMapper;
import com.trodix.episodate.episodateapi.persistence.mappers.SerieMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.text.StringSubstitutor;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SeriesService {

    private final SerieMapper serieMapper;
    private final LinkMapper linkMapper;

    public record SerieLinkQuery(String serieName, Integer season, Integer episode, String episodeName) {}

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class SerieLinkData {
        private String serieName;
        private List<String> urls = new ArrayList<>();
    }

    public SerieLinkData getSerieLinks(SerieLinkQuery query) {
        SerieLinkData data = new SerieLinkData();
        List<SerieLink> result = linkMapper.findLinks(query.serieName);

        for (SerieLink link : result) {
            data.setSerieName(link.getSerie().getName());
            data.getUrls().add(toSerieUrl(link, query));
        }

        return data;
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

    public Serie getOne(Long id) {
        return serieMapper.findById(id);
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
