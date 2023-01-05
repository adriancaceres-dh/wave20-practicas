package com.socialmeli.be_java_hisp_w20_g8.services.sellers;

import com.socialmeli.be_java_hisp_w20_g8.dto.*;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.InvalidArgumentException;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.NotFoundException;
import com.socialmeli.be_java_hisp_w20_g8.models.Seller;
import com.socialmeli.be_java_hisp_w20_g8.repositories.persons.IPersonRepository;
import com.socialmeli.be_java_hisp_w20_g8.repositories.posts.IPostRepository;
import com.socialmeli.be_java_hisp_w20_g8.utils.Validators;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class SellerService implements ISellerService {

    @Autowired
    IPersonRepository personRepository;
    @Autowired
    IPostRepository postRepository;

    public UserCountDTO followersCount(int userId) {
        Seller seller = personRepository.getById(userId);
        if (seller == null) {
            throw new NotFoundException("User not found: " + userId);
        }

        UserCountDTO userCountDTO = new UserCountDTO(userId, seller.getUser_name(), ((Seller) seller).getFollowers().size());
        return userCountDTO;

    }

    ModelMapper modelMapper = new ModelMapper();


    @Override
    public SellerFollowersDTO getSellerFollowers(Integer userId, String order) {

        Seller seller = personRepository.findSellerById(userId);

        if (seller != null) {

            SellerFollowersDTO sellerFollowersDTO = new SellerFollowersDTO(seller.getId(), seller.getUser_name(),
                    seller.getFollowers().stream().map(id -> personRepository.findUserById(id)).collect(Collectors.toList())
                            .stream().map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList()));

            String orderType = order != null ? order : "";

            if (!Validators.checkValidatorOptionName(orderType)) {
                throw new InvalidArgumentException("Invalid sorting option");
            }

            switch (orderType) {
                case "name_asc":
                    sellerFollowersDTO.setFollowers(sellerFollowersDTO.getFollowers().stream().sorted(Comparator.comparing(UserDTO::getUser_name)).collect(Collectors.toList()));
                    break;
                case "name_desc":
                    sellerFollowersDTO.setFollowers(sellerFollowersDTO.getFollowers().stream().sorted((a, b) -> b.getUser_name().compareTo(a.getUser_name())).collect(Collectors.toList()));
                    break;
            }

            return sellerFollowersDTO;

        } else {

            throw new NotFoundException("User with id: " + userId + " not found");
        }


    }

    @Override
    public PromosBySellerDto countPromos(int sellerId) {
        Seller seller = personRepository.findSellerById(sellerId);
        return PromosBySellerDto.builder()
                .userId(sellerId)
                .userName(seller.getUser_name())
                .promoProductsCount((int)postRepository.findPostsById(seller.getPost()).stream()
                        .filter(PostDTO::isHasPromo)
                        .count())
                .build();
    }

    @Override
    public ResponsePostDTO getAllPromoPostBySeller(int sellerId) {
        Seller seller = personRepository.findSellerById(sellerId);
        return ResponsePostDTO.builder()
                .id_user(sellerId)
                .posts(postRepository.findPostsById(seller.getPost()).stream()
                        .filter(PostDTO::isHasPromo).collect(Collectors.toList()))
                .build();
    }
}
