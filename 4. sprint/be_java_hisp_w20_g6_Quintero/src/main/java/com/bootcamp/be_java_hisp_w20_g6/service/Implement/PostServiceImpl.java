package com.bootcamp.be_java_hisp_w20_g6.service.Implement;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


import com.bootcamp.be_java_hisp_w20_g6.dto.response.*;
import com.bootcamp.be_java_hisp_w20_g6.exception.InvalidParamException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.be_java_hisp_w20_g6.dto.request.PostRequestDto;

import com.bootcamp.be_java_hisp_w20_g6.model.PostModel;
import com.bootcamp.be_java_hisp_w20_g6.repository.PostRepository;
import com.bootcamp.be_java_hisp_w20_g6.service.Interface.IPostService;
import com.bootcamp.be_java_hisp_w20_g6.service.Interface.IUserService;

import org.modelmapper.config.Configuration;

import static java.time.temporal.ChronoUnit.DAYS;

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
            postModel.setPost_id(postRepository.idGenerator());
            postRepository.save(postModel);
            return true;
    }

    @Override
    public PostListResponseDTO postFollowedLastWeeks(int user_id, String orderBy) {
        LocalDate dateNow=LocalDate.now();
        List<PostResponseDTO> followedPost=new ArrayList<>();
        for(int id : userService.getUserById(user_id).getFollowed()){
            postRepository.getPostList().stream().filter(p->p.getUser_id()==id)
                    .filter(p-> DAYS.between(p.getDate(),dateNow)<=15)
                    .forEach(p->followedPost.add(
                            new PostResponseDTO(p.getUser_id(),p.getPost_id(),p.getDate()
                                    ,p.getProduct(),p.getCategory(),p.getPrice())
                    ));
        }

        if(orderBy != null && orderBy.equals("date_asc")) {
            followedPost.sort(Comparator.comparing(PostResponseDTO::getDate));
        }else if(orderBy == null || orderBy.equals("date_desc")){
            followedPost.sort(Comparator.comparing(PostResponseDTO::getDate).reversed());
        }else{
            throw new InvalidParamException("Argumento invalido");
        }
        
        return new PostListResponseDTO(user_id,followedPost );
    }

    @Override
    public DiscountPostCountResponseDTO countDiscountPost(int sellerId) {
        String user_name=userService.getUserById(sellerId).getUser_name();
        int countPost=postRepository.getPostList().stream()
                        .filter(p->p.isHas_promo()==true)
                        .mapToInt(p-> p.getUser_id()!=sellerId ?0:1)
                        .sum();

        return new DiscountPostCountResponseDTO(sellerId,user_name,countPost);
    }

    @Override
    public DiscountPostListResponseDTO discountPostBySeller(int sellerId) {
        String user_name=userService.getUserById(sellerId).getUser_name();
        int user_id=userService.getUserById(sellerId).getUser_id();
        List<DiscountPostResponseDTO> discountPost=postRepository.getPostList().stream()
                .filter(p->p.getUser_id()==sellerId && p.isHas_promo()==true)
                .map(p-> mapper.map(p, DiscountPostResponseDTO.class))
                .collect(Collectors.toList());

        return new DiscountPostListResponseDTO(user_id,user_name,discountPost);
    }

}
