package com.trodix.episodate.v2.episodateapi.persistance.mappers;

import com.trodix.episodate.v2.episodateapi.persistance.entities.Serie;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SerieMapper {

     record SerieDataQuery(String serieName, Integer season, Integer episode) {}

     Serie findSerie(SerieDataQuery query);

}
