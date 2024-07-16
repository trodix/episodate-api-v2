package com.trodix.episodate.episodateapi.persistence.mappers;

import com.trodix.episodate.episodateapi.persistence.entities.Serie;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SerieMapper {

    List<Serie> findAll();

    Serie findById(Long id);

    Long insert(Serie serie);

    void update(Serie serie);

    void delete(Long id);

}
