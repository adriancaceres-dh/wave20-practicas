package com.bootcamp.be_java_hisp_w20_g6.service.Implement;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import com.bootcamp.be_java_hisp_w20_g6.dto.response.PostListResponseDTO;
import com.bootcamp.be_java_hisp_w20_g6.dto.response.PostPromoResponseDto;
import com.bootcamp.be_java_hisp_w20_g6.dto.response.PostResponseDTO;

import org.apache.catalina.User;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.be_java_hisp_w20_g6.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g6.exception.UserExistsException;
import com.bootcamp.be_java_hisp_w20_g6.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w20_g6.model.PostModel;
import com.bootcamp.be_java_hisp_w20_g6.model.UserModel;
import com.bootcamp.be_java_hisp_w20_g6.repository.PostRepository;
import com.bootcamp.be_java_hisp_w20_g6.service.Interface.IPostService;
import com.bootcamp.be_java_hisp_w20_g6.service.Interface.IUserService;

import org.modelmapper.config.Configuration;

@Service
public class PostServiceImpl implements IPostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private IUserService userService;

    private ModelMapper mapper;

    public PostServiceImpl() {
        super();
        mapper = new ModelMapper();
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

    }

    @Override
    public boolean save(PostRequestDto postRequestDto) {
            userService.getUserById(postRequestDto.getUser_id());
            PostModel postModel = mapper.map(postRequestDto, PostModel.class);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            postModel.setDate(LocalDate.parse(postRequestDto.getDate(),formatter));
            postModel.setId(postRepository.idGenerator());
            postRepository.save(postModel);
            return true;
    }
    @Override
    public PostPromoResponseDto getCountPostPromo(int user_id){
        try {
            UserModel user = userService.getUserById(user_id);
            List<PostModel> postsPromoUsers = postRepository.getPostsByUserId(user_id);  
            return new PostPromoResponseDto(user.getUser_id(), user.getUser_name(), postsPromoUsers.size());
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException("Usuario no existe");
        }
    }

    @Override
    public PostModel getPostById(int post_id){
        Optional<PostModel> post = postRepository.getPostById(post_id);
        return post.isPresent() ? post.get():null;
    }

    @Override
    public PostListResponseDTO postFollowedLastWeeks(int user_id, String orderBy) {
        LocalDate dateNow=LocalDate.now();
        List<PostResponseDTO> followedPost=new ArrayList<>();
        for(int id : userService.getUserById(user_id).getFollowed()){
            postRepository.getPostList().stream().filter(p->p.getUser_id()==id)
                    .filter(p-> DAYS.between(p.getDate(),dateNow)<=15)
                    .forEach(p->followedPost.add(
                            new PostResponseDTO(p.getUser_id(),p.getId(),p.getDate()
                                    ,p.getProduct(),p.getCategory(),p.getPrice())
                    ));
        }

        if(orderBy != null && orderBy.equals("date_asc")) {
            followedPost.sort(Comparator.comparing(PostResponseDTO::getDate));
        }else{
            followedPost.sort(Comparator.comparing(PostResponseDTO::getDate).reversed());
        }
        
        return new PostListResponseDTO(user_id,followedPost );
    }

}
