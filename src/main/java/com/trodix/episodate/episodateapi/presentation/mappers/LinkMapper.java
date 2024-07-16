package com.trodix.episodate.episodateapi.presentation.mappers;

import com.trodix.episodate.episodateapi.persistence.entities.Link;
import com.trodix.episodate.episodateapi.persistence.entities.LinkRepresentation;
import com.trodix.episodate.episodateapi.persistence.entities.SerieLink;
import com.trodix.episodate.episodateapi.presentation.dto.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface LinkMapper {

    Link toModel(LinkCreateRequest dto);
    Link toModel(LinkUpdateRequest dto);

    LinkResponse toDto(Link model);
    List<LinkResponse> toDto(List<Link> model);

    List<SerieLinkResponse> toDto2(List<SerieLink> model);

    List<LinkRepresentationResponse> toDto3(List<LinkRepresentation> model);

}
