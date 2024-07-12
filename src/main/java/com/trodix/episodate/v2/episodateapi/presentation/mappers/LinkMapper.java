package com.trodix.episodate.v2.episodateapi.presentation.mappers;

import com.trodix.episodate.v2.episodateapi.persistence.entities.Link;
import com.trodix.episodate.v2.episodateapi.presentation.dto.LinkCreateRequest;
import com.trodix.episodate.v2.episodateapi.presentation.dto.LinkUpdateRequest;
import org.mapstruct.Mapper;

@Mapper
public interface LinkMapper {

    Link toModel(LinkCreateRequest dto);
    Link toModel(LinkUpdateRequest dto);

}
