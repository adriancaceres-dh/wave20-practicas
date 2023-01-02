package com.bootcamp.be_java_hisp_w20_g1.service;

import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserFollowedResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserFollowersCountResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserFollowersResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.model.User;
import com.bootcamp.be_java_hisp_w20_g1.repository.interfaces.IUserRepository;
import com.bootcamp.be_java_hisp_w20_g1.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    public UserFollowersResponseDto getSellerFollowers(int id){
        UserFollowersResponseDto userResponse = new UserFollowersResponseDto();
        User user = userRepository.getUserById(id);
        doValidations(user);
        userResponse.setUserId(user.getId());
        userResponse.setUserName(user.getName());
        userResponse.setFollowers(getFollowersDto(user));
        return userResponse;
    }

    public UserFollowersCountResponseDto getFollowersCount(int id) {
        User user = userRepository.getUserById(id);
        doValidations(user);
        UserFollowersCountResponseDto userFollowersCountResponse = new UserFollowersCountResponseDto();
        userFollowersCountResponse.setUserId(user.getId());
        userFollowersCountResponse.setUserName(user.getName());
        userFollowersCountResponse.setFollowersCount(user.getFollowed().size());
        return userFollowersCountResponse;
    }

    private List<UserResponseDto> getFollowersDto(User user) {
        return user.getFollowed()
                .stream()
                .map(userId -> {
                    User follower = this.userRepository.getUserById(userId);
                    return new UserResponseDto(follower.getId(), follower.getName());
                })
                .collect(Collectors.toList());
    }

    private void doValidations(User user) {
        if(user == null){
            System.out.println("el usuario no existe");
        }
        if(user.isSeller()){
            System.out.println("El usuario no es vendedor");
        }
    }
}
