package com.trodix.episodate.v2.episodateapi.presentation.controllers;

import com.trodix.episodate.v2.episodateapi.domain.services.SeriesService;
import com.trodix.episodate.v2.episodateapi.persistence.entities.Serie;
import com.trodix.episodate.v2.episodateapi.presentation.dto.SerieCreateRequest;
import com.trodix.episodate.v2.episodateapi.presentation.dto.SerieUpdateRequest;
import com.trodix.episodate.v2.episodateapi.presentation.mappers.SerieMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/admin/series")
@RequiredArgsConstructor
public class AdminSeriesController {

    private final SerieMapper serieMapper;
    private final SeriesService seriesService;

    @GetMapping
    public List<Serie> getAll() {
        return seriesService.getAll();
    }

    @PostMapping
    public void createSerie(@Valid @RequestBody SerieCreateRequest serie) {
        seriesService.create(serieMapper.toModel(serie));
    }

    @PutMapping
    public void updateSerie(@Valid @RequestBody SerieUpdateRequest serie) {
        seriesService.update(serieMapper.toModel(serie));
    }

    @DeleteMapping("{id}")
    public void deleteSerie(Long id) {
        seriesService.delete(id);
    }

}
