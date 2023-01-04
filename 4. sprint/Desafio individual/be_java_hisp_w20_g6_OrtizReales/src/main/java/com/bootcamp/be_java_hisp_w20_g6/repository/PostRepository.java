package com.bootcamp.be_java_hisp_w20_g6.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.Getter;
import org.springframework.stereotype.Repository;

import com.bootcamp.be_java_hisp_w20_g6.model.PostModel;


@Repository
@Getter
public class PostRepository {

    private List<PostModel> postList;

    public PostRepository() {
        super();
        postList = new ArrayList<>();
    }

    public PostModel save(PostModel postModel) {
        postList.add(postModel);
        return postModel;
    }

    public int idGenerator(){
        return postList.size()+1;
    }

    public List<PostModel> getPostsByUserId(int user_id){
        return postList.stream().filter(p -> (p.getUser_id() == user_id && p.isHas_promo())).collect(Collectors.toList());
    }

    public Optional<PostModel> getPostById(int post_id){
        return postList.stream().filter(p -> p.getId() == post_id).findFirst();
    }

}
