package com.socialMeli.be_java_hisp_w20_g03.service;

import com.socialMeli.be_java_hisp_w20_g03.dto.UserDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.UserFollowerCountDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.UserFollowersDTO;
import com.socialMeli.be_java_hisp_w20_g03.model.User;
import com.socialMeli.be_java_hisp_w20_g03.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService implements IUserService{

    @Autowired
    IUserRepository iUserRepository;
    ModelMapper mapper = new ModelMapper();

    @Override
    public boolean addFollower(int userId, int userIdToFollow) {
        return false;
    }

    @Override
    public UserFollowerCountDTO getFollowerCount(int userId) {
        return null;
    }

    @Override
    public UserFollowersDTO getFollowersList(int userId) {
        return null;
    }

    @Override
    public UserFollowersDTO getFollowedList(int userId, String order) {
        User user = iUserRepository.getUserById(userId);
        if (user != null) {
            List<UserDTO> followed = user.getFollowed().stream()
                    .map(u -> mapper.map(u, UserDTO.class)).collect(Collectors.toList());
            if (order != null) {
                if (order.equals("name_asc")){
                    followed = followed.stream().sorted(Comparator.comparing(x -> x.getUser_name())).collect(Collectors.toList());
                }else{
                    followed = followed.stream().sorted(Comparator.comparing(x -> x.getUser_name(), Comparator.reverseOrder())).collect(Collectors.toList());
                }
            }
            return new UserFollowersDTO(user.getUser_id(), user.getUser_name(), followed);
        }
        return null;
    }

    @Override
    public boolean unfollow(int userId, int UserIdToUnfollow) {
        return false;
    }
}
