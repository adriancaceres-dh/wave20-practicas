package com.example.links.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvalidateLinkResponseDto {
    private long id;
    private String message;

    public InvalidateLinkResponseDto(long id) {
        this.id = id;
        this.message = "Link has been invalidated";
    }
}
