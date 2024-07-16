package com.trodix.episodate.episodateapi.presentation.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SerieLinkDataResponse {
    private String serieName;
    private List<String> urls = new ArrayList<>();
}
