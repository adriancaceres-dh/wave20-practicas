package com.bootcamp.be_java_hisp_w20_g1.service;

import com.bootcamp.be_java_hisp_w20_g1.dto.response.*;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserFollowedResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserFollowersResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.UserResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.model.User;
import com.bootcamp.be_java_hisp_w20_g1.repository.interfaces.IUserRepository;
import com.bootcamp.be_java_hisp_w20_g1.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.ArrayList;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserFollowersResponseDto getSellerFollowersDto(int id, String order){
        UserFollowersResponseDto userResponse = new UserFollowersResponseDto();
        User user = userRepository.getUserById(id);
        doValidations(user);
        userResponse.setUserId(user.getId());
        userResponse.setUserName(user.getName());
        userResponse.setFollowers(getFollowersDto(user, order));
        return userResponse;
    }

    private List<UserResponseDto> getFollowersDto(User user, String order) {
        return getUserListDto(user.getFollowers(), order);
    }

    @Override
    public UserFollowersCountResponseDto getFollowersCountDto(int id) {
        User user = userRepository.getUserById(id);
        doValidations(user);
        UserFollowersCountResponseDto userFollowersCountResponse = new UserFollowersCountResponseDto();
        userFollowersCountResponse.setUserId(user.getId());
        userFollowersCountResponse.setUserName(user.getName());
        userFollowersCountResponse.setFollowersCount(user.getFollowers().size());
        return userFollowersCountResponse;
    }

    @Override
    public UserFollowedResponseDto getFollowedDto(int id, String order) {
        User user = userRepository.getUserById(id);
        validateUserExist(user);
        UserFollowedResponseDto userFollowedResponseDto = new UserFollowedResponseDto();
        userFollowedResponseDto.setUserId(user.getId());
        userFollowedResponseDto.setUserName(user.getName());
        userFollowedResponseDto.setFollowed(getFollowedDto(user, order));
        return userFollowedResponseDto;
    }

    private List<UserResponseDto> getFollowedDto(User user, String order) {
        return getUserListDto(user.getFollowed(), order);
    }

    private List<UserResponseDto> getUserListDto(Set<Integer> users, String order) {
        List<UserResponseDto> filteredUsers = users.stream()
                .map(userId -> {
                    User follower = this.userRepository.getUserById(userId);
                    return new UserResponseDto(follower.getId(), follower.getName());
                })
                .collect(Collectors.toList());
        return trySortOrderAlphabetically(filteredUsers, order);
    }

    private List<UserResponseDto> trySortOrderAlphabetically(List<UserResponseDto> users, String order) {
        if(order == null){
            return users;
        } else if(order.equalsIgnoreCase("name_asc")) {
            return users
                    .stream()
                    .sorted(Comparator.comparing(UserResponseBaseDto::getUserName))
                    .collect(Collectors.toList());
        } else if(order.equalsIgnoreCase("name_desc")){
            return users
                    .stream()
                    .sorted(Comparator.comparing(UserResponseBaseDto::getUserName).reversed())
                    .collect(Collectors.toList());
        }
        return users;
    }

    private void doValidations(User user) {
        validateUserExist(user);
        if(user.isSeller()){
            System.out.println("El usuario no es vendedor");
        }
    }

    private void validateUserExist(User user) {
        if (user == null) {
            System.out.println("el usuario no existe");
        }
    }

    @Override
    public ResponseEntity<UserFollowedResponseDto> followUser(int userId, int userIdToFollow){

        if (userId == userIdToFollow || !userRepository.isValidId(userId) || !userRepository.isValidId(userIdToFollow) )
            throw new RuntimeException("Id invalido");

        if(!userRepository.isSeller(userIdToFollow)) {
            throw new RuntimeException("El usuario a seguir no es un vendedor");
        }

        User user = userRepository.getUserById(userId);

        userRepository.addFollowed(userId,userIdToFollow);
        userRepository.addFollower(userIdToFollow, userId);

        List<UserResponseDto> userFollowedList = new ArrayList<>();
        for (Integer userFollowedId : user.getFollowed() ){
            User userFollowed = userRepository.getUserById(userFollowedId);
            userFollowedList.add(new UserResponseDto(userFollowedId,userFollowed.getName()));
        }

        return ResponseEntity.ok(new UserFollowedResponseDto(user.getId(),user.getName(),userFollowedList));
    }

    @Override
    public ResponseEntity<UserFollowedResponseDto> unfollowUser(int userId, int userIdToUnfollow){

        if (userId == userIdToUnfollow || !userRepository.isValidId(userId) || !userRepository.isValidId(userIdToUnfollow) )
            throw new RuntimeException("Id invalido");


        User user = userRepository.getUserById(userId);

        userRepository.removeFollowed(userId,userIdToUnfollow);
        userRepository.removeFollower(userIdToUnfollow, userId);

        System.out.println(userRepository.getUserById(userId) + " " + userRepository.getUserById(userIdToUnfollow));

        List<UserResponseDto> userFollowedList = new ArrayList<>();
        for (Integer userFollowedId : user.getFollowed() ){
            User userFollowed = userRepository.getUserById(userFollowedId);
            userFollowedList.add(new UserResponseDto(userFollowedId,userFollowed.getName()));
        }

        return ResponseEntity.ok(new UserFollowedResponseDto(user.getId(),user.getName(),userFollowedList));
    }
}
