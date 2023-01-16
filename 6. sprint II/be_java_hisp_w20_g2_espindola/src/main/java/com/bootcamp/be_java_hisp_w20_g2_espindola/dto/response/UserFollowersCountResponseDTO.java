package com.bootcamp.be_java_hisp_w20_g2_espindola.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserFollowersCountResponseDTO {
    private int userId;
    private String userName;
    private int followersCount;
}
