package com.bootcamp.be_java_hisp_w20_g1_ramosruiz.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserFollowedResponseDto extends UserResponseBaseDto {
    private List<UserResponseDto> followed;

    public UserFollowedResponseDto(int id, String name, List<UserResponseDto> userFollowedList) {
        super(id, name);
        followed = userFollowedList;
    }
}
