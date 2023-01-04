package com.socialmeli.be_java_hisp_w20_g8.services.posts;


import com.socialmeli.be_java_hisp_w20_g8.dto.PostDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.ResponsePostDTO;
import com.socialmeli.be_java_hisp_w20_g8.models.Seller;
import com.socialmeli.be_java_hisp_w20_g8.repositories.persons.PersonRepositoryImp;
import com.socialmeli.be_java_hisp_w20_g8.repositories.posts.PostRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {

    @Autowired
    PersonRepositoryImp personRepositoryImp;

    @Autowired
    PostRepositoryImp postRepositoryImp;


    @Override
    public ResponsePostDTO findSellersByIdUser(int id) {
        if (personRepositoryImp.checkUser(id)) {
            Set<Integer> followedSellers = personRepositoryImp.getAllFollowed(id);
            Set<Seller> sellers = followedSellers.stream().map(seller_id -> personRepositoryImp.findSellerById(seller_id)).collect(Collectors.toSet());
            return findPostByIdSeller(sellers, id);
        }
        else {
            return null;
        }
    }

    @Override
    public ResponsePostDTO findPostByIdSeller(Set<Seller> sellers, int idUser) {
       Set<PostDTO> setPostSeller = new HashSet<>();
       sellers.stream().forEach(seller -> postRepositoryImp.findPostsById(seller.getPost()).forEach(x-> setPostSeller.add(x)));

       return ResponsePostDTO.builder().id_user(idUser).posts(setPostSeller).build();
    }
}
