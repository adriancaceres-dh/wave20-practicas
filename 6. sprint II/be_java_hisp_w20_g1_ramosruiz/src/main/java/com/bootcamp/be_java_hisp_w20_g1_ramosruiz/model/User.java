package com.bootcamp.be_java_hisp_w20_g1_ramosruiz.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private Set<Integer> followers;
    private Set<Integer> followed;
    private Set<Integer> posts;
    private boolean isSeller;
}
