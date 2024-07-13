package com.trodix.episodate.v2.episodateapi.presentation.mappers;

import com.trodix.episodate.v2.episodateapi.persistence.entities.Link;
import com.trodix.episodate.v2.episodateapi.persistence.entities.SerieLink;
import com.trodix.episodate.v2.episodateapi.presentation.dto.LinkCreateRequest;
import com.trodix.episodate.v2.episodateapi.presentation.dto.LinkResponse;
import com.trodix.episodate.v2.episodateapi.presentation.dto.LinkUpdateRequest;
import com.trodix.episodate.v2.episodateapi.presentation.dto.SerieLinkResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface LinkMapper {

    Link toModel(LinkCreateRequest dto);
    Link toModel(LinkUpdateRequest dto);

    LinkResponse toDto(Link model);
    List<LinkResponse> toDto(List<Link> model);

    List<SerieLinkResponse> toDto2(List<SerieLink> model);

}