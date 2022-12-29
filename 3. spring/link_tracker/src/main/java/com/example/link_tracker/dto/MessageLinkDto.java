package com.example.link_tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MessageLinkDto {

    private String message;

    private LinkDto linkDto;
}
