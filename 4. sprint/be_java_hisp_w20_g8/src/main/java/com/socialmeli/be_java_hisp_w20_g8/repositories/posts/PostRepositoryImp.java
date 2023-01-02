package com.socialmeli.be_java_hisp_w20_g8.repositories.posts;


import com.socialmeli.be_java_hisp_w20_g8.dto.PostDTO;
import com.socialmeli.be_java_hisp_w20_g8.models.Person;
import com.socialmeli.be_java_hisp_w20_g8.models.Seller;
import com.socialmeli.be_java_hisp_w20_g8.models.User;
import com.socialmeli.be_java_hisp_w20_g8.repositories.persons.PersonRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PostRepositoryImp implements PostRepository{

    @Autowired
    PersonRepositoryImp personRepositoryImp;

    private final Map<Integer, Set<PostDTO>> postsMap;

    public PostRepositoryImp() {
        postsMap = new HashMap<>();
    }


    @Override
    public List<PostDTO> findALlPostsByIdUser(int id) {


        return null;
    }


    public boolean findUserById(int id){
        System.out.println(personRepositoryImp.loadUsers());

        return false;
    }
}
