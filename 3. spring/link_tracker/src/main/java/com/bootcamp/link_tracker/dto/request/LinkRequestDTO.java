package com.bootcamp.link_tracker.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LinkRequestDTO {

    private String link;
    private String password;

}
