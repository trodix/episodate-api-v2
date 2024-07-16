package com.trodix.episodate.episodateapi.persistence.entities;

import lombok.Data;

@Data
public class Link {

    private Long id;
    private Long serieId;
    private String urlPattern;
}
