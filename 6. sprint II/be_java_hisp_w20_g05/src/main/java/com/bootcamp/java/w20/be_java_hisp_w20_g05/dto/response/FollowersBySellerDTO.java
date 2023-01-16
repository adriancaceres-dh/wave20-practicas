package com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FollowersBySellerDTO {
    @JsonProperty("user_id")
    int id;
    @JsonProperty("user_name")
    String name;
    @JsonProperty("followers")
    List<UserResponseDTO> followers;

    @Override
    public int hashCode () {
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj.getClass() != this.getClass()) return false;

        FollowersBySellerDTO dto = (FollowersBySellerDTO) obj;

        // userId
        if (this.id != dto.getId()) return false;

        // userName
        if (!this.name.equals(dto.getName())) return false;

        // followed
        if(this.followers.size() != dto.followers.size()) return false;
        // Si no son del mismo tamaño ni se gasta en comparar los elementos
        for (int i=0; i < this.followers.size(); i++) {
            if (!this.followers.get(i).equals(dto.getFollowers().get(i))) { // Si en el mismo index != elementos entonces ->
                return false; // las listas no son iguales
            }
        }
        return true;
    }

}
