package com.socialmeli.be_java_hisp_w20_g8.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class Person {

    private Integer id;
    private String user_name;
}
