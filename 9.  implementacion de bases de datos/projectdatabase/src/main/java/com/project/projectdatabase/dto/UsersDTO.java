package com.project.projectdatabase.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsersDTO {

    private Integer document;
    private String name;
    private Integer cellPhone;
}
