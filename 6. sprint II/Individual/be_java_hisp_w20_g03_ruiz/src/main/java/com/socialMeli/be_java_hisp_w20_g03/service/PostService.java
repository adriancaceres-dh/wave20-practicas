package com.socialMeli.be_java_hisp_w20_g03.service;

import com.socialMeli.be_java_hisp_w20_g03.dto.request.PostDTO;
import com.socialMeli.be_java_hisp_w20_g03.exception.BadRequestException;
import com.socialMeli.be_java_hisp_w20_g03.exception.NotFoundException;
import com.socialMeli.be_java_hisp_w20_g03.model.Post;
import com.socialMeli.be_java_hisp_w20_g03.repository.IPostRepository;
import com.socialMeli.be_java_hisp_w20_g03.repository.IUserRepository;
import com.socialMeli.be_java_hisp_w20_g03.model.User;
import com.socialMeli.be_java_hisp_w20_g03.utils.DateOrder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PostService implements IPostService {

    @Autowired
    IPostRepository postRepository;
    @Autowired
    IUserRepository userRepository;
    ModelMapper mapper = new ModelMapper();

    int postId = 0;

    @Override
    public String addPost(PostDTO postDTO) {

        if (userRepository.getUserById(postDTO.getUserId()) == null) {
            throw new NotFoundException("El usuario ingresado no existe");
        }
        Post post = mapper.map(postDTO, Post.class);
        post.setPostId(++postId);
        postRepository.addPost(post);
        return "Publicación agregada";
    }

    @Override
    public List<PostDTO> getPost(int userId, String order) {
        List<PostDTO> postList = new ArrayList<>();
        User userEx = userRepository.getUserById(userId);

        if (userEx == null) {
            throw new NotFoundException("El usuario ingresado no existe.");
        }
        for (User user : userEx.getFollowed()) {
            postList.addAll(postRepository.getPostsByUserId(user.getUserId()).stream()
                    .map(u -> mapper.map(u, PostDTO.class)).collect(Collectors.toList()));
        }
        if (order != null ) {
            if (order.equals(DateOrder.date_desc.toString())) {
                postList = postList.stream().sorted(Comparator.comparing(PostDTO::getDate, Comparator.reverseOrder())).collect(Collectors.toList());
            } else if (order.equals(DateOrder.date_asc.toString())) {
                postList = postList.stream().sorted(Comparator.comparing(PostDTO::getDate)).collect(Collectors.toList());
            } else {
                throw new BadRequestException("El orden ingresado no es valido.");
            }
        }  else {
            postList = postList.stream().sorted(Comparator.comparing(PostDTO::getDate, Comparator.reverseOrder())).collect(Collectors.toList());
        }
        return postList;
    }
}
