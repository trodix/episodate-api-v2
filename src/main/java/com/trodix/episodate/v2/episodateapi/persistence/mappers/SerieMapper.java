package com.trodix.episodate.v2.episodateapi.persistence.mappers;

import com.trodix.episodate.v2.episodateapi.persistence.entities.SerieLink;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SerieMapper {

     List<SerieLink> findLinks(String serieName);

}
