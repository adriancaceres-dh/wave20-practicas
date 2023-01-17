package com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.UserResponseDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FollowedListDTO {

    @JsonProperty("user_id")
    private int id;
    @JsonProperty("user_name")
    private String name;
    public List<UserResponseDTO> followed = new ArrayList<>();

    public FollowedListDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode () {
        return id;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj.getClass() != this.getClass()) return false;

        FollowedListDTO dto = (FollowedListDTO) obj;

        // userId
        if (this.id != dto.getId()) return false;

        // userName
        if (!this.name.equals(dto.getName())) return false;

        // followed
        if(this.followed.size() != dto.followed.size()) return false;
        // Si no son del mismo tamaño ni se gasta en comparar los elementos
        for (int i=0; i < this.followed.size(); i++) {
            if (!this.followed.get(i).equals(dto.getFollowed().get(i))) { // Si en el mismo index != elementos entonces ->
                return false; // las listas no son iguales
            }
        }
        return true;
    }

}
