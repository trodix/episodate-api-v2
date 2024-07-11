package com.trodix.episodate.v2.episodateapi.persistence.entities;

import lombok.Data;

@Data
public class SerieLink {
    private String serieName;
    private Integer season;
    private Integer episode;
    private String urlPattern;
}