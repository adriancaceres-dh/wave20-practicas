package com.example.qatesters.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageDto {
  private String message;
  private String action;
}
