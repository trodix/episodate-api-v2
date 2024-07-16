package com.trodix.episodate.episodateapi.persistence.entities;

import lombok.Data;

@Data
public class SerieLink {

    private Long id;
    private String urlPattern;
    private Serie serie;

}