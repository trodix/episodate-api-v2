package com.trodix.episodate.episodateapi.presentation.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SerieUpdateRequest {

    @NotNull
    private Integer id;

    @NotEmpty
    private String name;

}
