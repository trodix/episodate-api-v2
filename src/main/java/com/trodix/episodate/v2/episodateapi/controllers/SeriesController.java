package com.trodix.episodate.v2.episodateapi.controllers;

import com.trodix.episodate.v2.episodateapi.persistance.entities.Serie;
import com.trodix.episodate.v2.episodateapi.persistance.mappers.SerieMapper;
import com.trodix.episodate.v2.episodateapi.services.SeriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/series")
@RequiredArgsConstructor
public class SeriesController {

    private final SeriesService serieService;

    @GetMapping
    public Serie getSerieData(@RequestParam String serieName, @RequestParam Integer season, @RequestParam Integer episode) {

        var data = new SerieMapper.SerieDataQuery(serieName, season, episode);
        return serieService.getSerieData(data);
    }

}
