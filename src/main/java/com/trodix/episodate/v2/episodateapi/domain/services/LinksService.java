package com.trodix.episodate.v2.episodateapi.domain.services;

import com.trodix.episodate.v2.episodateapi.persistence.entities.Link;
import com.trodix.episodate.v2.episodateapi.persistence.entities.SerieLink;
import com.trodix.episodate.v2.episodateapi.persistence.mappers.LinkMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LinksService {

    private final LinkMapper linkMapper;

    public List<SerieLink> getAll() {
        return linkMapper.findAll();
    }

    public Link create(Link link) {
        linkMapper.insert(link);
        return link;
    }

    public void update(Link link) {
        linkMapper.update(link);
    }

    public void delete(Long id) {
        linkMapper.delete(id);
    }

}