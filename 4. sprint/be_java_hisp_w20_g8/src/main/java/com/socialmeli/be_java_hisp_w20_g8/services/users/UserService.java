package com.socialmeli.be_java_hisp_w20_g8.services.users;


import com.socialmeli.be_java_hisp_w20_g8.dto.ResponseDto;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.NotFoundException;
import com.socialmeli.be_java_hisp_w20_g8.repositories.persons.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    PersonRepository personRepository;

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
