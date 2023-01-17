package com.socialmeli.be_java_hisp_w20_g8.services.users;


import com.socialmeli.be_java_hisp_w20_g8.dto.*;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.InvalidArgumentException;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.OperationFailedException;
import com.socialmeli.be_java_hisp_w20_g8.models.Seller;
import com.socialmeli.be_java_hisp_w20_g8.dto.ResponseDTO;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.NotFoundException;
import com.socialmeli.be_java_hisp_w20_g8.models.User;
import com.socialmeli.be_java_hisp_w20_g8.repositories.persons.IPersonRepository;
import com.socialmeli.be_java_hisp_w20_g8.utils.Validators;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/**
 * This service allows the interaction between the user controller and the user repository, performing the operations
 * of get a user with all the sellers he follows, allows the user to follow a seller and allows the user to unfollow
 * a seller
 * @author: Grupo 8
 */


@Service
public class UserService implements IUserService {

    @Autowired
    IPersonRepository personRepository;
    ModelMapper modelMapper = new ModelMapper();

    /**
     * create a list of sellers followed by a specific user and is sorted by the order option
     * @author: Luis López Gómez
     * @param userId id of the user
     * @param order sorting option used in the method
     * @return userFollowedDTO with the id of the user, his name and the list of sellers the users follows
     */
    public UserFollowedDTO getAllFollowed(int userId, String order) {
        if (personRepository.checkUser(userId)) {
            // Getting User and converting to UserDTO
            User user = personRepository.findUserById(userId);


            //Getting List of sellers and converting to SellerDTO
            List<Seller> sellers = personRepository.getAllFollowed(userId).stream()
                    .map(seller_id -> personRepository.findSellerById(seller_id))
                    .collect(Collectors.toList());

            List<SellerDTO> sellersDTO = sellers.stream()
                    .map(seller -> modelMapper.map(seller, SellerDTO.class))
                    .collect(Collectors.toList());

            String orderType = order != null ? order : "";
            if (!Validators.checkValidatorOptionName(orderType)) {
                throw new InvalidArgumentException("Invalid sorting option");
            }
            switch (orderType) {
                case "name_asc":
                    sellersDTO = sellersDTO.stream().sorted(Comparator.comparing(SellerDTO::getUser_name)).collect(Collectors.toList());
                    break;
                case "name_desc":
                    sellersDTO = sellersDTO.stream().sorted((a, b) -> b.getUser_name().compareTo(a.getUser_name())).collect(Collectors.toList());
                    break;
            }

            return new UserFollowedDTO(user.getId(), user.getUser_name(), sellersDTO);

        } else {
            throw new NotFoundException("Invalid user please check information.");
        }
    }

    public ResponseDTO addNewFollow(int userId, int sellerId) {
        if(userId == sellerId) throw new OperationFailedException("A user can't follow himself");
        if (personRepository.checkUser(userId) && personRepository.checkUser(sellerId)) {
            personRepository.addFollowing(userId, sellerId);
            personRepository.addFollower(sellerId, userId);
            return ResponseDTO.builder()
                    .ok(true)
                    .message("New Follower add successfully").build();
        } else {
            throw new NotFoundException("Invalid users please check information.");
        }
    }

    @Override
    public ResponseDTO unfollow(int userid, int sellerId) {
        if (personRepository.checkUser(userid) && personRepository.checkUser(sellerId)) {
            personRepository.unfollowing(userid, sellerId);
            personRepository.unfollower(sellerId, userid);
            return ResponseDTO.builder()
                    .ok(true)
                    .message("you have unfollowed the user").build();
        } else {
            throw new NotFoundException("Invalid users please check information.");
        }
    }
}
