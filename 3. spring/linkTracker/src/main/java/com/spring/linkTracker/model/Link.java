package com.spring.linkTracker.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Link {
    private int id;
    private String linkRedirect;
    private int countRedirect;
    private String password;
}
