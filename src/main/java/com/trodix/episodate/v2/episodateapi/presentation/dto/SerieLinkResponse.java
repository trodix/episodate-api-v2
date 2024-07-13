package com.trodix.episodate.v2.episodateapi.presentation.dto;

import lombok.Data;

@Data
public class SerieLinkResponse {
    private Long id;
    private String urlPattern;
    private SerieResponse serie;
}
