package com.trodix.episodate.episodateapi.presentation.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

@Data
public class LinkUpdateRequest {

    @NotNull
    private final Integer id;

    @NotNull
    private final Integer serieId;

    @URL
    @NotEmpty
    private final String urlPattern;
}
