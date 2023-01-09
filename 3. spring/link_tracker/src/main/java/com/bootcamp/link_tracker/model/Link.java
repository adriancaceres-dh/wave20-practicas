package com.bootcamp.link_tracker.model;

import com.bootcamp.link_tracker.service.LinksService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Link {

    private int id;
    private String link;
    private String password;
    private int cantRedirect;
    private static int nextId = 1;

    public Link(String link, String password){
        this.id = nextId++;
        this.cantRedirect = 0;
        this.link = link;
        this.password = password;
    }

    public void incrementCantRedirect(){
        this.cantRedirect++;
    }
}
