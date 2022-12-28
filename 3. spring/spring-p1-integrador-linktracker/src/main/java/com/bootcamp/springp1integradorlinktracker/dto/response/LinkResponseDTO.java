package com.bootcamp.springp1integradorlinktracker.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LinkResponseDTO {
    private int linkID;

    public int getLinkID() {
        return linkID;
    }

    public LinkResponseDTO(int linkID) {
        this.linkID = linkID;
    }
}
