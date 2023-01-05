package com.socialmeli.be_java_hisp_w20_g03.dto;

import lombok.*;

import java.util.List;
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FavoritePostsListDTO {
  private int userId;
  private List<PostDTO> posts;
}
