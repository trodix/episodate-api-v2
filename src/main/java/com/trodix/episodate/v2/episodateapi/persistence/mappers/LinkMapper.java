package com.trodix.episodate.v2.episodateapi.persistence.mappers;

import com.trodix.episodate.v2.episodateapi.persistence.entities.Link;
import com.trodix.episodate.v2.episodateapi.persistence.entities.SerieLink;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LinkMapper {

     List<SerieLink> findLinks(String serieName);

     List<SerieLink> findAll();

     Long insert(Link link);

     void update(Link link);

     void delete(Long id);

}
