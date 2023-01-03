package com.bootcamp.be_java_hisp_w20_g6_villamizar.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bootcamp.be_java_hisp_w20_g6_villamizar.dto.response.PostResponseDTO;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import com.bootcamp.be_java_hisp_w20_g6_villamizar.model.PostModel;


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


    public List<PostModel> getUserPostedList(int id ){
        return postList.stream().filter(p-> p.getUser_id() == id).collect(Collectors.toList());
    }

    public List<PostModel> promoPostsList() { return postList.stream().filter(PostModel::isHas_promo).collect(Collectors.toList()); }

}
