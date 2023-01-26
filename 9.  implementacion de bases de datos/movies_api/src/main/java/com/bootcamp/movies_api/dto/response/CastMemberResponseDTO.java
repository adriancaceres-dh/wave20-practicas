package com.bootcamp.movies_api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CastMemberResponseDTO {
    private String first_name;
    private String last_name;
    private Double rating;

}
