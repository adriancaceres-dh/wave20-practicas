package com.bootcamp.be_java_hisp_w20_g7.service;

import com.bootcamp.be_java_hisp_w20_g7.dto.UserDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserFollowedDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserFollowersCountDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserFollowersDto;
import com.bootcamp.be_java_hisp_w20_g7.entity.Follow;
import com.bootcamp.be_java_hisp_w20_g7.entity.User;
import com.bootcamp.be_java_hisp_w20_g7.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w20_g7.repository.IFollowRepository;
import com.bootcamp.be_java_hisp_w20_g7.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    IFollowRepository iFollowRepository;

    @Autowired
    IUserRepository iUserRepository;

    ModelMapper modelMapper;

    Comparator<User> compareByName = Comparator
            .comparing(User::getUserName);

    public UserService() {
        modelMapper = new ModelMapper();
    }

    @Override
    public UserFollowersDto userFollowers(int userId, String order) {

        User user = iUserRepository.findById(userId);
        if (user == null) throw new UserNotFoundException("User not found");

        List<Follow> follows = iFollowRepository.findAll().stream().filter(e -> e.getIdFollowed() == userId).collect(Collectors.toList());

        List<User> followers;

        if(order == null){
            followers = follows.stream().map(e -> iUserRepository.findById(e.getIdFollower())).collect(Collectors.toList());
        } else {
            if (order.equals("name_asc")) {
                followers = follows.stream().map(e -> iUserRepository.findById(e.getIdFollower())).sorted(compareByName).collect(Collectors.toList());
            } else if (order.equals("name_desc")) {
                followers = follows.stream().map(e -> iUserRepository.findById(e.getIdFollower())).sorted(compareByName.reversed()).collect(Collectors.toList());
            } else {
                followers = follows.stream().map(e -> iUserRepository.findById(e.getIdFollower())).collect(Collectors.toList());
            }
        }

        List<UserDto> userDtos = followers.stream().map(e -> modelMapper.map(e, UserDto.class)).collect(Collectors.toList());
        User followed = iUserRepository.findById(userId);

        return new UserFollowersDto(followed.getUserId(), followed.getUserName(),userDtos);

    }

    @Override
    public UserFollowedDto userFollowed(int userId, String order) {

        User user = iUserRepository.findById(userId);
        if (user == null) throw new UserNotFoundException("User not found");

        List<Follow> followList = iFollowRepository.findAll().stream().filter(follow -> follow.getIdFollower() == userId).collect(Collectors.toList());
        List<User> userFollowedList;

        if(order == null){
            userFollowedList = followList.stream().map(e -> iUserRepository.findById(e.getIdFollowed())).collect(Collectors.toList());
        }else{
            if (order.equals("name_asc")) {
                userFollowedList = followList.stream().map(e -> iUserRepository.findById(e.getIdFollowed())).sorted(compareByName).collect(Collectors.toList());
            } else if (order.equals("name_desc")) {
                userFollowedList = followList.stream().map(e -> iUserRepository.findById(e.getIdFollowed())).sorted(compareByName.reversed()).collect(Collectors.toList());
            } else {
                userFollowedList = followList.stream().map(e -> iUserRepository.findById(e.getIdFollowed())).collect(Collectors.toList());
            }
        }

        List<UserDto> userFollowedDtoList = userFollowedList.stream().map(f -> modelMapper.map(f, UserDto.class)).collect(Collectors.toList());
        User follower = iUserRepository.findById(userId);

        return new UserFollowedDto(follower.getUserId(), follower.getUserName(),userFollowedDtoList);
    }

    @Override
    public UserFollowersCountDto countFollowers(int userId) {

        User user = iUserRepository.findById(userId);
        if (user == null) throw new UserNotFoundException("User not found");

        int followerCount = (int) iFollowRepository.findAll().stream().filter(e -> e.getIdFollowed() == userId).count();

        return new UserFollowersCountDto(userId, user.getUserName(), followerCount);
    }
}
