package com.trodix.episodate.episodateapi.presentation.mappers;

import com.trodix.episodate.episodateapi.domain.services.SeriesService;
import com.trodix.episodate.episodateapi.persistence.entities.LinkRepresentation;
import com.trodix.episodate.episodateapi.persistence.entities.Serie;
import com.trodix.episodate.episodateapi.presentation.dto.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        imports = LinkMapper.class
)
public interface SerieMapper {

    Serie toModel(SerieCreateRequest dto);
    Serie toModel(SerieUpdateRequest dto);

    SerieResponse toDto(Serie serie);
    SerieAdminResponse toDto5(Serie serie);
    List<SerieResponse> toDto2(List<Serie> serie);
    List<SerieAdminResponse> toDto4(List<Serie> serie);

    SerieLinkDataResponse toDto(SeriesService.SerieLinkData dto);
    List<SerieLinkDataResponse> toDto(List<SeriesService.SerieLinkData> dto);


    List<LinkRepresentationResponse> toDto3(List<LinkRepresentation> model);

}
