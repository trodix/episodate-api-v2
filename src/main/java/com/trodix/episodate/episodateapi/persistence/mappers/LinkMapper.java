package com.trodix.episodate.episodateapi.persistence.mappers;

import com.trodix.episodate.episodateapi.persistence.entities.SerieLink;
import com.trodix.episodate.episodateapi.persistence.entities.Link;
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
