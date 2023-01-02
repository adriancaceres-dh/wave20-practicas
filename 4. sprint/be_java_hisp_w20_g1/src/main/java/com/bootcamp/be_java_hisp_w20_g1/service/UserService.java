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
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    //US 3
    public UserFollowersResponseDto getSellerFollowersDto(int id){
        UserFollowersResponseDto userResponse = new UserFollowersResponseDto();
        User user = userRepository.getUserById(id);
        doValidations(user);
        userResponse.setUserId(user.getId());
        userResponse.setUserName(user.getName());
        userResponse.setFollowers(getFollowersDto(user));
        return userResponse;
    }

    private List<UserResponseDto> getFollowersDto(User user) {
        return getUserListDto(user.getFollowers());
    }

    //US 2
    public UserFollowersCountResponseDto getFollowersCountDto(int id) {
        User user = userRepository.getUserById(id);
        doValidations(user);
        UserFollowersCountResponseDto userFollowersCountResponse = new UserFollowersCountResponseDto();
        userFollowersCountResponse.setUserId(user.getId());
        userFollowersCountResponse.setUserName(user.getName());
        userFollowersCountResponse.setFollowersCount(user.getFollowers().size());
        return userFollowersCountResponse;
    }

    //US 4
    public UserFollowedResponseDto getFollowedDto(int id) {
        User user = userRepository.getUserById(id);
        validateUserExist(user);
        UserFollowedResponseDto userFollowedResponseDto = new UserFollowedResponseDto();
        userFollowedResponseDto.setUserId(user.getId());
        userFollowedResponseDto.setUserName(user.getName());
        userFollowedResponseDto.setFollowed(getFollowedDto(user));
        return userFollowedResponseDto;
    }

    private List<UserResponseDto> getFollowedDto(User user) {
        return getUserListDto(user.getFollowed());
    }

    private List<UserResponseDto> getUserListDto(Set<Integer> users) {
        return users.stream()
                .map(userId -> {
                    User follower = this.userRepository.getUserById(userId);
                    return new UserResponseDto(follower.getId(), follower.getName());
                })
                .collect(Collectors.toList());
    }

    private void doValidations(User user) {
        validateUserExist(user);
        if(user.isSeller()){
            System.out.println("El usuario no es vendedor");
        }
    }

    private void validateUserExist(User user) {
        if(user == null){
            System.out.println("el usuario no existe");
        }
    }
}
