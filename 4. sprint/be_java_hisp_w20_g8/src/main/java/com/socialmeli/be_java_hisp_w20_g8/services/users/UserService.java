package com.socialmeli.be_java_hisp_w20_g8.services.users;


import com.socialmeli.be_java_hisp_w20_g8.dto.ResponseDto;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.NotFoundException;
import com.socialmeli.be_java_hisp_w20_g8.repositories.persons.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private PersonRepository personRepository;

    public ResponseDto addNewFollow(int userId, int sellerId) {
        if (personRepository.checkUser(userId) && personRepository.checkUser(sellerId)) {
            personRepository.addFollowing(userId, sellerId);
            personRepository.addFollower(sellerId, userId);
            return ResponseDto.builder()
                    .ok(true)
                    .message("New Follower add successfully").build();
        } else {
            throw new NotFoundException("Invalid users please check information.");
        }
    }

    @Override
    public ResponseDto unfollow(int userid, int sellerId) {
        if (personRepository.checkUser(userid) && personRepository.checkUser(sellerId)) {
            personRepository.unfollowing(userid, sellerId);
            personRepository.unfollower(sellerId, userid);
            return ResponseDto.builder()
                    .ok(true)
                    .message("you have deleted a follower").build();
        } else {
            throw new NotFoundException("Invalid users please check information.");
        }
    }
}
