package com.bootcamp.link_tracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Link {
    private String link;
    private String password;
    private int redirections;

    public Link(String link, String password) {
        this.link = link;
        this.password = password;
        this.redirections = 0;
    }

    public void addRedirection() {
        redirections++;
    }

    public boolean verifyPassword(String password) {
        return this.password.equals(password);
    }
}
