package com.trodix.episodate.episodateapi.presentation.controllers;

import com.trodix.episodate.episodateapi.domain.services.SeriesService;
import com.trodix.episodate.episodateapi.presentation.dto.SerieLinkDataResponse;
import com.trodix.episodate.episodateapi.presentation.dto.SerieResponse;
import com.trodix.episodate.episodateapi.presentation.mappers.SerieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/public/series")
@RequiredArgsConstructor
public class SeriesController {

    private final SeriesService seriesService;
    private final SerieMapper serieMapper;

    @GetMapping
    public List<SerieResponse> getAll() {
        return serieMapper.toDto2(seriesService.getAll());
    }

    @GetMapping("{id}")
    public SerieResponse getOne(@PathVariable Long id) {
        return serieMapper.toDto(seriesService.getOne(id));
    }

    @GetMapping("search")
    public SerieLinkDataResponse getSerieData(@RequestParam String serieName, @RequestParam Integer season, @RequestParam Integer episode, @RequestParam(required = false) String episodeName) {

        var data = new SeriesService.SerieLinkQuery(serieName, season, episode, episodeName);
        SeriesService.SerieLinkData res = seriesService.getSerieLinks(data);
        return serieMapper.toDto(res);
    }

}
