package com.trodix.episodate.v2.episodateapi.controllers;

import com.trodix.episodate.v2.episodateapi.services.SeriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2/series")
@RequiredArgsConstructor
public class SeriesController {

    private final SeriesService serieService;

    @GetMapping
    public List<SeriesService.SerieData> getSerieData(@RequestParam String serieName, @RequestParam Integer season, @RequestParam Integer episode, @RequestParam(required = false) String episodeName) {

        var data = new SeriesService.SerieDataQuery(serieName, season, episode, episodeName);
        return serieService.getSerieData(data);
    }

}
