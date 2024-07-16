package com.trodix.episodate.episodateapi.presentation.dto;

import lombok.Data;

@Data
public class LinkResponse {
    private Long id;
    private Long serieId;
    private String urlPattern;
}
