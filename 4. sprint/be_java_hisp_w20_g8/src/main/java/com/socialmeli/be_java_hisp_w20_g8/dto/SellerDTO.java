package com.socialmeli.be_java_hisp_w20_g8.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SellerDTO {

    private Integer id;
    private String user_name;

    private Set<Integer> followers;
    private Set<Integer> post;

    @Override
    public String toString() {
        return "SellerDTO{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", followers=" + followers +
                ", post=" + post +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Set<Integer> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<Integer> followers) {
        this.followers = followers;
    }

    public Set<Integer> getPost() {
        return post;
    }

    public void setPost(Set<Integer> post) {
        this.post = post;
    }

    public SellerDTO(Integer id, String user_name, Set<Integer> followers, Set<Integer> post) {
        this.id = id;
        this.user_name = user_name;
        this.followers = followers;
        this.post = post;
    }
}
