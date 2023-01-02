package com.socialmeli.be_java_hisp_w20_g8.dto;


import com.socialmeli.be_java_hisp_w20_g8.models.Person;
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

    private Person person;
    private Set<Integer> following;
}
