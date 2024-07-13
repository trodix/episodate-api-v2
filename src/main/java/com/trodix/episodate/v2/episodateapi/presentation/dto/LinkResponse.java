package com.trodix.episodate.v2.episodateapi.presentation.dto;

import lombok.Data;

@Data
public class LinkResponse {
    private Long id;
    private Long serieId;
    private String urlPattern;
}
