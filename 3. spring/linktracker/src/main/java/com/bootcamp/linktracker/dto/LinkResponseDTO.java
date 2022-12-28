package com.bootcamp.linktracker.dto;

import com.bootcamp.linktracker.model.Link;
import lombok.Getter;

@Getter
public class LinkResponseDTO {
    private long id;
    private String link;
    private long visits;
    private Boolean isValid;

    public LinkResponseDTO() {
    }

    public LinkResponseDTO(Link link) {
        id = link.getId();
        this.link = link.getLink();
        visits = link.getVisits();
        isValid = link.getIsValid();
    }

}
