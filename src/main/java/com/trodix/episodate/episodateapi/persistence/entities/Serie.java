package com.trodix.episodate.episodateapi.persistence.entities;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Serie {

    private Long id;
    private String name;
    List<LinkRepresentation> linkPatterns = new ArrayList<>();

}
