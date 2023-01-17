package com.bootcamp.be_java_hisp_w20_g2_alderete.service;

import com.bootcamp.be_java_hisp_w20_g2_alderete.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2_alderete.dto.PostWithIdDTO;
import com.bootcamp.be_java_hisp_w20_g2_alderete.dto.PostPromotionDTO;
import com.bootcamp.be_java_hisp_w20_g2_alderete.dto.request.PromotionRequestDTO;
import com.bootcamp.be_java_hisp_w20_g2_alderete.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_alderete.dto.response.AmountOfPromotionsDTO;
import com.bootcamp.be_java_hisp_w20_g2_alderete.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g2_alderete.model.Post;
import com.bootcamp.be_java_hisp_w20_g2_alderete.model.User;
import com.bootcamp.be_java_hisp_w20_g2_alderete.repository.interfaces.ICategoryRepository;
import com.bootcamp.be_java_hisp_w20_g2_alderete.repository.interfaces.IPostRepository;
import com.bootcamp.be_java_hisp_w20_g2_alderete.repository.interfaces.IUserRepository;
import com.bootcamp.be_java_hisp_w20_g2_alderete.service.interfaces.IProductService;
import com.bootcamp.be_java_hisp_w20_g2_alderete.utils.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ProductService implements IProductService {
    @Autowired
    private IPostRepository postRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ICategoryRepository categoryRepository;
    @Autowired
    private PostMapper postMapper;


    @Override
    public String createPost(PostDTO postRequestDTO) {
        User user = getUserOrThrow(postRequestDTO.getUserId());

        Post newPost = postMapper.toPost(postRequestDTO);
        user.addPost(newPost);

        userRepository.save(user);
        return "Post creado.";
    }


    @Override
    public PostResponseDTO<PostWithIdDTO> sendLastPostOfFollowed(int userId, Optional<String> order) {
        User user = getUserOrThrow(userId);

        List<PostWithIdDTO> posts = user.getFollowing().stream()
                .map(User::getPosts)
                .flatMap(Collection::stream)
                .sorted(getDateComparator(order))
                .map(postMapper::toWithIdDTO)
                .collect(Collectors.toList());

        return new PostResponseDTO<>(userId, posts);
    }

    @Override
    public String createPromoPost(PromotionRequestDTO postRequestDTO) {
        User user = getUserOrThrow(postRequestDTO.getUserId());

        Post post = postMapper.toPost(postRequestDTO);
        user.addPost(post);

        userRepository.save(user);
        return "Post de promoción creado.";
    }

    @Override
    public AmountOfPromotionsDTO getAmountOfPromos(int userId) {
        User user = getUserOrThrow(userId);

        long amountOfPromos = user.getPosts().stream().filter(Post::isHasPromo).count();

        return new AmountOfPromotionsDTO(userId, user.getUserName(), amountOfPromos);
    }

    @Override
    public PostResponseDTO<PostPromotionDTO> listPromosFromUser(int userId, Optional<String> order) {
        User user = getUserOrThrow(userId);

        List<PostPromotionDTO> posts = user.getPosts().stream()
                .filter(Post::isHasPromo)
                .sorted(getDateComparator(order))
                .map(postMapper::toWithPromoDTO)
                .collect(Collectors.toList());

        return new PostResponseDTO<>(userId, posts);
    }

    private User getUserOrThrow(int userId) {
        User user = userRepository.findOne(userId);
        if (user == null) {
            throw new BadRequestException("Id no encontrada.");
        }

        return user;
    }

    private Comparator<Post> getDateComparator(Optional<String> order) {
        return order.orElse("date_desc").equals("date_desc") ?
                Comparator.comparing(Post::getDate).reversed()
                : Comparator.comparing(Post::getDate);
    }

}
