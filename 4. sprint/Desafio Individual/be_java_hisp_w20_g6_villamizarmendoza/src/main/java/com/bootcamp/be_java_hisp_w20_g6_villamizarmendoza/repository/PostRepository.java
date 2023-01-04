package com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.repository;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import org.springframework.stereotype.Repository;

import com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.model.PostModel;


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

}
