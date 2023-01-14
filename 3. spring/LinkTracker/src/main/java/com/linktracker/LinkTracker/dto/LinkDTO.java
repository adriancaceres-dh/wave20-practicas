package com.linktracker.LinkTracker.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class LinkDTO {

    private int id;

    private String link;
}
