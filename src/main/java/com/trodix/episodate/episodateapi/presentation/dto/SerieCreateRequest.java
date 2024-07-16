package com.trodix.episodate.episodateapi.presentation.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SerieCreateRequest {

    @NotEmpty
    private String name;

}
