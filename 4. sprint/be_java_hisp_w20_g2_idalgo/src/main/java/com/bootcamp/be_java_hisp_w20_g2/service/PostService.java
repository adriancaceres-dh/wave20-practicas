package com.bootcamp.be_java_hisp_w20_g2.service;

import com.bootcamp.be_java_hisp_w20_g2.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.request.PromoPostRequestDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g2.model.Post;
import com.bootcamp.be_java_hisp_w20_g2.model.User;
import com.bootcamp.be_java_hisp_w20_g2.repository.interfaces.ICategoryRepository;
import com.bootcamp.be_java_hisp_w20_g2.repository.interfaces.IPostRepository;
import com.bootcamp.be_java_hisp_w20_g2.repository.interfaces.IUserRepository;
import com.bootcamp.be_java_hisp_w20_g2.service.interfaces.IPostService;
import com.bootcamp.be_java_hisp_w20_g2.utils.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Optional;


@Service
public class PostService implements IPostService {
    @Autowired
    private IPostRepository postRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ICategoryRepository categoryRepository;
    @Autowired
    private PostMapper postMapper;

    /*
     * Validar que exista el userId. Si está no existe no es posible crearla, ya que no debería crearse un nuevo
     * usuario desde una nueva publicación.
     * Validar que exista la categoria. Si está no existe no es posible crearla, ya que no debería crearse una nueva
     * categoria desde una nueva publicación.
     */
    @Override
    public void createPost(PostDTO postRequestDTO) {
        User user = getUserOrThrow(postRequestDTO.getUserId());

        Post newPost = postMapper.toPost(postRequestDTO);
        user.addPost(newPost);

        userRepository.save(user);
    }

    @Override
    public void createPromoPost(PromoPostRequestDTO postRequestDTO) {
        User user = getUserOrThrow(postRequestDTO.getUserId());

        Post post = postMapper.toPost(postRequestDTO);
        user.addPost(post);

        userRepository.save(user);
    }

    @Override
    public PostResponseDTO sendLastPostOfFollowed(int userId, Optional<String> order) {
        User user = getUserOrThrow(userId);

        PostResponseDTO postResponse = new PostResponseDTO(userId);

        user.getFollowing()
                .forEach(followedUser -> {
                    followedUser.getPosts().stream()
                            .sorted(this.getDateComparator(order))
                            .filter(post -> post.getDate().isAfter(LocalDate.now().minusWeeks(2)))
                            .forEach(post -> postResponse.addPost(postMapper.toWithIdDTO(post, followedUser.getId())));
                });

        return postResponse;
    }

    private User getUserOrThrow(int userId) {
        User user = userRepository.findOne(userId);
        if (user == null) {
            throw new BadRequestException("The given userId not exist.");
        }

        return user;
    }

    private Comparator<Post> getDateComparator(Optional<String> order) {
        return order.orElse("date_desc").equals("date_desc") ?
                Comparator.comparing(Post::getDate).reversed()
                : Comparator.comparing(Post::getDate);
    }

}
