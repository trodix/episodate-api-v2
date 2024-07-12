package com.trodix.episodate.v2.episodateapi.presentation.controllers;

import com.trodix.episodate.v2.episodateapi.domain.services.LinksService;
import com.trodix.episodate.v2.episodateapi.persistence.entities.SerieLink;
import com.trodix.episodate.v2.episodateapi.presentation.dto.LinkCreateRequest;
import com.trodix.episodate.v2.episodateapi.presentation.dto.LinkUpdateRequest;
import com.trodix.episodate.v2.episodateapi.presentation.mappers.LinkMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/admin/links")
@RequiredArgsConstructor
public class AdminLinkController {

    private final LinkMapper linkMapper;

    private final LinksService linksService;

    @GetMapping
    public List<SerieLink> getAll() {
        return linksService.getAll();
    }

    @PostMapping
    public void createLink(LinkCreateRequest link) {
        linksService.create(linkMapper.toModel(link));
    }

    @PutMapping
    public void updateLink(LinkUpdateRequest link) {
        linksService.update(linkMapper.toModel(link));
    }

    @DeleteMapping("{id}")
    public void deleteLink(Long id) {
        linksService.delete(id);
    }

}
