package com.trodix.episodate.v2.episodateapi.persistence.mappers;

import com.trodix.episodate.v2.episodateapi.persistence.entities.Serie;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SerieMapper {

    List<Serie> findAll();

    Serie insert(Serie serie);

    Serie update(Serie serie);

    void delete(Long id);

}
