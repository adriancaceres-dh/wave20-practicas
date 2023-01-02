package com.socialmeli.be_java_hisp_w20_g8.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDTO {

<<<<<<< HEAD
    private Integer id;
=======
    private  int id;
    private  String userName;

    private Set<Integer> following;
>>>>>>> 2627f9d0cfb73fa843f448f4545647298793adea
}
