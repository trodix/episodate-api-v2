package com.trodix.episodate.episodateapi.presentation.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SerieAdminResponse {

    private Long id;
    private String name;
    private List<LinkRepresentationResponse> linkPatterns = new ArrayList<>();

}
