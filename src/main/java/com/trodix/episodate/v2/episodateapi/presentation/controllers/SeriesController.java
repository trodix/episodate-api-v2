package com.trodix.episodate.v2.episodateapi.presentation.controllers;

import com.trodix.episodate.v2.episodateapi.domain.services.SeriesService;
import com.trodix.episodate.v2.episodateapi.presentation.dto.SerieLinkDataResponse;
import com.trodix.episodate.v2.episodateapi.presentation.mappers.SerieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2/public/series")
@RequiredArgsConstructor
public class SeriesController {

    private final SeriesService serieService;
    private final SerieMapper serieMapper;

    @GetMapping
    public List<SerieLinkDataResponse> getSerieData(@RequestParam String serieName, @RequestParam Integer season, @RequestParam Integer episode, @RequestParam(required = false) String episodeName) {

        var data = new SeriesService.SerieLinkQuery(serieName, season, episode, episodeName);
        return serieMapper.toDto(serieService.getSerieLinks(data));
    }

}
