package com.socialmeli.be_java_hisp_w20_g8.services.users;


import com.socialmeli.be_java_hisp_w20_g8.dto.SellerDTO;
import com.socialmeli.be_java_hisp_w20_g8.models.Person;
import com.socialmeli.be_java_hisp_w20_g8.models.Seller;
import com.socialmeli.be_java_hisp_w20_g8.repositories.persons.PersonRepositoryImp;
import com.socialmeli.be_java_hisp_w20_g8.dto.ResponseDto;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.NotFoundException;
import com.socialmeli.be_java_hisp_w20_g8.repositories.persons.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    PersonRepository personRepository;

    public List<Seller> getAllFollowed(int userId){
        if (personRepository.checkUser(userId)){
        Set<Integer> followedSellers = personRepository.getAllFollowed(userId);
        List<Seller> sellers = followedSellers.stream().map(seller_id -> personRepository.findSellerById(seller_id)).collect(Collectors.toList());
        return sellers;

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
