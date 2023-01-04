package com.bootcamp.be_java_hisp_w20_g7_anttury.service;

import com.bootcamp.be_java_hisp_w20_g7_anttury.dto.UserDto;
import com.bootcamp.be_java_hisp_w20_g7_anttury.dto.response.UserFollowedDto;
import com.bootcamp.be_java_hisp_w20_g7_anttury.dto.response.UserFollowersCountDto;
import com.bootcamp.be_java_hisp_w20_g7_anttury.dto.response.UserFollowersDto;
import com.bootcamp.be_java_hisp_w20_g7_anttury.dto.response.UserPostFollowedDto;
import com.bootcamp.be_java_hisp_w20_g7_anttury.entity.Follow;
import com.bootcamp.be_java_hisp_w20_g7_anttury.entity.User;
import com.bootcamp.be_java_hisp_w20_g7_anttury.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w20_g7_anttury.repository.IFollowRepository;
import com.bootcamp.be_java_hisp_w20_g7_anttury.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public UserFollowersCountDto userFollowersCount(int userId) {
        return null;
    }

    @Override
    public UserFollowersDto userFollowers(int userId, String order) {

        List<Follow> follows = iFollowRepository.findAll().stream().filter(e -> e.getIdFollowed() == userId).collect(Collectors.toList());

        List<User> followers = new ArrayList<>();

        if (order.equals("name_asc")) {
            followers = follows.stream().map(e -> iUserRepository.findById(e.getIdFollower())).sorted(compareByName).collect(Collectors.toList());
        } else if (order.equals("name_desc")) {
            followers = follows.stream().map(e -> iUserRepository.findById(e.getIdFollower())).sorted(compareByName.reversed()).collect(Collectors.toList());
        } else {
            followers = follows.stream().map(e -> iUserRepository.findById(e.getIdFollower())).collect(Collectors.toList());
        }

        List<UserDto> userDtos = followers.stream().map(e -> modelMapper.map(e, UserDto.class)).collect(Collectors.toList());
        User followed = iUserRepository.findById(userId);

        return new UserFollowersDto(userDtos, followed.getUserId(), followed.getUserName());

    }

    @Override
    public UserFollowedDto userFollowed(int userId, String order) {

        List<Follow> followList = iFollowRepository.findAll().stream().filter(follow -> follow.getIdFollower() == userId).collect(Collectors.toList());
        List<User> userFollowedList;

        if (order.equals("name_asc")) {
            userFollowedList = followList.stream().map(e -> iUserRepository.findById(e.getIdFollowed())).sorted(compareByName).collect(Collectors.toList());
        } else if (order.equals("name_desc")) {
            userFollowedList = followList.stream().map(e -> iUserRepository.findById(e.getIdFollowed())).sorted(compareByName.reversed()).collect(Collectors.toList());
        } else {
            userFollowedList = followList.stream().map(e -> iUserRepository.findById(e.getIdFollowed())).collect(Collectors.toList());
        }

        List<UserDto> userFollowedDtoList = userFollowedList.stream().map(f -> modelMapper.map(f, UserDto.class)).collect(Collectors.toList());
        User follower = iUserRepository.findById(userId);

        return new UserFollowedDto(userFollowedDtoList, follower.getUserId(), follower.getUserName());
    }

    @Override
    public UserPostFollowedDto userPostFollowed(int userId) {
        return null;
    }

    @Override
    public UserFollowersCountDto countFollowers(int userId) {

        User user = iUserRepository.findById(userId);

        if (user == null) throw new UserNotFoundException("user with id " + userId + " not found");

        int followerCount = iFollowRepository.findAll().stream().filter(e -> e.getIdFollowed() == userId).collect(Collectors.toList()).size();

        return new UserFollowersCountDto(userId, user.getUserName(), followerCount);


    }
}
