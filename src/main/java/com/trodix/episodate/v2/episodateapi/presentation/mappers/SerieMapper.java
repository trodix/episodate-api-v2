package com.trodix.episodate.v2.episodateapi.presentation.mappers;

import com.trodix.episodate.v2.episodateapi.domain.services.SeriesService;
import com.trodix.episodate.v2.episodateapi.persistence.entities.Serie;
import com.trodix.episodate.v2.episodateapi.presentation.dto.SerieCreateRequest;
import com.trodix.episodate.v2.episodateapi.presentation.dto.SerieLinkDataResponse;
import com.trodix.episodate.v2.episodateapi.presentation.dto.SerieResponse;
import com.trodix.episodate.v2.episodateapi.presentation.dto.SerieUpdateRequest;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface SerieMapper {

    Serie toModel(SerieCreateRequest dto);
    Serie toModel(SerieUpdateRequest dto);

    SerieResponse toDto(Serie serie);
    List<SerieResponse> toDto2(List<Serie> serie);

    SerieLinkDataResponse toDto(SeriesService.SerieLinkData dto);
    List<SerieLinkDataResponse> toDto(List<SeriesService.SerieLinkData> dto);

}
