package com.trodix.episodate.v2.episodateapi.controllers;

import com.trodix.episodate.v2.episodateapi.services.SeriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v2/admin/series")
@RequiredArgsConstructor
public class AdminSeriesController {

    private final SeriesService serieService;

    @GetMapping("hello")
    public String hello() {
        return "World!";
    }

}
