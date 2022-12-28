package com.bootcamp.linktracker.model;

import com.google.common.hash.Hashing;
import lombok.Getter;
import lombok.Setter;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Getter
@Setter
public class Link {
    private long id;
    private String link;
    private long visits;
    private Optional<String> password;
    private Boolean isValid;

    public Link(String link) {
        this.link = link;
        this.visits = 0;
        this.password = Optional.empty();
        this.isValid = true;
    }

    public Link(String link, String password) {
        this.link = link;
        this.visits = 0;
        this.password = Optional.of(
                Hashing.sha256()
                        .hashString(password, StandardCharsets.UTF_8)
                        .toString()
        );
        this.isValid = true;
    }

    public void addVisit() {
        visits++;
    }
}
