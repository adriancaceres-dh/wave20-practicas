package com.bootcamp.LinkTracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter @Getter
public class LinkDTO {
    private Integer linkId;
    private String link;
    private String password;
    private Integer count;

    public LinkDTO(){
        this.count = 0;
    }

    public void sumCount(){
        count++;
    }

}
