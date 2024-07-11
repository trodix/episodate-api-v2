package com.trodix.episodate.v2.episodateapi.services;

import com.trodix.episodate.v2.episodateapi.persistance.entities.Serie;
import com.trodix.episodate.v2.episodateapi.persistance.mappers.SerieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeriesService {

    private final SerieMapper serieMapper;

    public Serie getSerieData(SerieMapper.SerieDataQuery data) {
        return serieMapper.findSerie(data);
    }

}
