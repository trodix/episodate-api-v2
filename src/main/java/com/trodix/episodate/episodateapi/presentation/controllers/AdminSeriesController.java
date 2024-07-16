package com.trodix.episodate.episodateapi.presentation.controllers;

import com.trodix.episodate.episodateapi.domain.services.SeriesService;
import com.trodix.episodate.episodateapi.presentation.dto.SerieAdminResponse;
import com.trodix.episodate.episodateapi.presentation.dto.SerieCreateRequest;
import com.trodix.episodate.episodateapi.presentation.dto.SerieResponse;
import com.trodix.episodate.episodateapi.presentation.dto.SerieUpdateRequest;
import com.trodix.episodate.episodateapi.presentation.mappers.SerieMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/series")
@RequiredArgsConstructor
public class AdminSeriesController {

    private final SerieMapper serieMapper;
    private final SeriesService seriesService;

    @GetMapping("{id}/link-patterns")
    public SerieAdminResponse getAllLinkPatterns(@PathVariable Long id) {
        return serieMapper.toDto5(seriesService.getOne(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SerieAdminResponse createSerie(@Valid @RequestBody SerieCreateRequest serie) {
        return serieMapper.toDto5(seriesService.create(serieMapper.toModel(serie)));
    }

    @PutMapping
    public void updateSerie(@Valid @RequestBody SerieUpdateRequest serie) {
        seriesService.update(serieMapper.toModel(serie));
    }

    @DeleteMapping("{id}")
    public void deleteSerie(@PathVariable Long id) {
        seriesService.delete(id);
    }

}
