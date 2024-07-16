package com.trodix.episodate.episodateapi.presentation.controllers;

import com.trodix.episodate.episodateapi.domain.services.LinksService;
import com.trodix.episodate.episodateapi.presentation.dto.LinkCreateRequest;
import com.trodix.episodate.episodateapi.presentation.dto.LinkUpdateRequest;
import com.trodix.episodate.episodateapi.presentation.dto.LinkResponse;
import com.trodix.episodate.episodateapi.presentation.dto.SerieLinkResponse;
import com.trodix.episodate.episodateapi.presentation.mappers.LinkMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/links")
@RequiredArgsConstructor
public class AdminLinkController {

    private final LinkMapper linkMapper;

    private final LinksService linksService;

    @GetMapping
    public List<SerieLinkResponse> getAll() {
        return linkMapper.toDto2(linksService.getAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LinkResponse createLink(@Valid @RequestBody LinkCreateRequest link) {
        return linkMapper.toDto(linksService.create(linkMapper.toModel(link)));
    }

    @PutMapping
    public void updateLink(@Valid @RequestBody LinkUpdateRequest link) {
        linksService.update(linkMapper.toModel(link));
    }

    @DeleteMapping("{id}")
    public void deleteLink(@PathVariable Long id) {
        linksService.delete(id);
    }

}
