package com.bootcamp.be_java_hisp_w20_g7.service;

import com.bootcamp.be_java_hisp_w20_g7.dto.UserDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserFollowedDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserFollowersCountDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserFollowersDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserPostFollowedDto;
import com.bootcamp.be_java_hisp_w20_g7.entity.Follow;
import com.bootcamp.be_java_hisp_w20_g7.entity.User;
import com.bootcamp.be_java_hisp_w20_g7.repository.IFollowRepository;
import com.bootcamp.be_java_hisp_w20_g7.repository.IUserRepository;
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

    public UserService() {
        modelMapper = new ModelMapper();

    }

    @Override
    public UserFollowersCountDto userFollowersCount(int userId) {
        return null;
    }

    @Override
    public UserFollowersDto userFollowers(int userId, String order) {
        Comparator<User> compareByName = Comparator
                .comparing(User::getUserName);

        List<Follow> follows = iFollowRepository.findAll().stream().filter(e -> e.getIdFollowed() == userId).collect(Collectors.toList());

        List<User> followers = new ArrayList<>();

        if(order.equals("name_asc")){
            followers = follows.stream().map(e -> iUserRepository.findById(e.getIdFollower())).sorted(compareByName).collect(Collectors.toList());
        }else if(order.equals("name_desc")){
            followers = follows.stream().map(e -> iUserRepository.findById(e.getIdFollower())).sorted(compareByName.reversed()).collect(Collectors.toList());
        }else {
            followers = follows.stream().map(e -> iUserRepository.findById(e.getIdFollower())).collect(Collectors.toList());
        }

        List<UserDto> userDtos = followers.stream().map(e -> modelMapper.map(e,UserDto.class)).collect(Collectors.toList());
        User followed = iUserRepository.findById(userId);

        return new UserFollowersDto(followed.getUserId(),followed.getUserName(),userDtos);

    }

    @Override
    public UserFollowedDto userFollowed(int userId) {

        List<Follow> followList = iFollowRepository.findAll().stream().filter(follow -> follow.getIdFollower() == userId).collect(Collectors.toList());
        List<User> userFollowedList = followList.stream().map(follow -> iUserRepository.findById(follow.getIdFollowed())).collect(Collectors.toList());
        List<UserDto> userFollowedDtoList = userFollowedList.stream().map(f -> modelMapper.map(f, UserDto.class)).collect(Collectors.toList());
        User followed = iUserRepository.findById(userId);

        return new UserFollowedDto(followed.getUserId(), followed.getUserName(), userFollowedDtoList);
    }

    @Override
    public UserPostFollowedDto userPostFollowed(int userId) {
        return null;
    }
}
