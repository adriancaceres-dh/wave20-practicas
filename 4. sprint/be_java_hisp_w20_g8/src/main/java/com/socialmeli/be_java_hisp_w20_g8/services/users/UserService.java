package com.socialmeli.be_java_hisp_w20_g8.services.users;


import com.socialmeli.be_java_hisp_w20_g8.dto.SellerDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.UserFollowedDTO;
import com.socialmeli.be_java_hisp_w20_g8.models.Seller;
import com.socialmeli.be_java_hisp_w20_g8.dto.ResponseDto;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.NotFoundException;
import com.socialmeli.be_java_hisp_w20_g8.models.User;
import com.socialmeli.be_java_hisp_w20_g8.repositories.persons.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    PersonRepository personRepository;
    ModelMapper modelMapper = new ModelMapper();
    public UserFollowedDTO getAllFollowed(int userId){
        if (personRepository.checkUser(userId)){
            // Getting User and converting to UserDTO
            User user = personRepository.findUserbyId(userId);


            //Getting List of sellers and converting to SellerDTO
            List<Seller> sellers = personRepository.getAllFollowed(userId).stream()
                    .map(seller_id -> personRepository.findSellerById(seller_id))
                    .collect(Collectors.toList());

            List<SellerDTO> sellersDTO = sellers.stream()
                    .map(seller -> modelMapper.map(seller,SellerDTO.class))
                    .collect(Collectors.toList());
            return new UserFollowedDTO(user.getId(),user.getUser_name(),sellersDTO);

        }else{
            throw new NotFoundException("Invalid user please check information.");
        }
    }

    public ResponseDto addNewFollow(int userId, int sellerId){
        if(personRepository.checkUser(userId) && personRepository.checkUser(sellerId)){
            personRepository.addFollowing(userId,sellerId);
            personRepository.addFollower(sellerId,userId);
            return ResponseDto.builder()
                    .ok(true)
                    .message("New Follower add successfully").build();
        }
        else {
            throw new NotFoundException("Invalid users please check information.");
        }

    }
}
