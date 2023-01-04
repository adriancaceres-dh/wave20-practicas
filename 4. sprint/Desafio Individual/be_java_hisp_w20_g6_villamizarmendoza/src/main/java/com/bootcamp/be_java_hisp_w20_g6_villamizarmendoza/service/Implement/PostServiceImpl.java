package com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.service.Implement;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


import com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.dto.response.*;
import com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.exception.InvalidParamException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.dto.request.PostRequestDto;

import com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.model.PostModel;
import com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.repository.PostRepository;
import com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.service.Interface.IPostService;
import com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.service.Interface.IUserService;

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
        postModel.setId(postRepository.idGenerator());
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
                            new PostResponseDTO(p.getUser_id(),p.getId(),p.getDate()
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
    public PromoPostCountResponseDto getPromosCount(int id) {
          long promoListCount = postRepository.getPostList().stream()
                    .filter(PostModel::isHas_promo)
                    .filter(p-> p.getUser_id() == id)
                    .count();

            String username = userService.getUserById(id).getUser_name();
            return new PromoPostCountResponseDto(id, username, ((int) promoListCount));

    }

    @Override
    public PromoPostListResponseDTO getPromoPostList(int user_id, String orderBy) {
        List<PromoPostResponseDTO> promoPostList = postRepository.getPostList().stream()
                .filter(PostModel::isHas_promo)
                .filter(p-> p.getUser_id() == user_id)
                .map(p -> mapper.map(p, PromoPostResponseDTO.class))
                .collect(Collectors.toList());
/*
        if(orderBy != null && orderBy.equals("date_asc")) {
            promoPostList.sort(Comparator.comparing(PostResponseDTO::getDate));
        }else{
            promoPostList.sort(Comparator.comparing(PostResponseDTO::getDate).reversed());
        }
*/
        String username = userService.getUserById(user_id).getUser_name();
        return new PromoPostListResponseDTO(user_id, username, promoPostList );
    }

}
