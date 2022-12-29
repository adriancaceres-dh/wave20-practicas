package com.socialMeli.be_java_hisp_w20_g03.service;

import com.socialMeli.be_java_hisp_w20_g03.dto.UserFollowerCountDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.UserFollowersDTO;
import com.socialMeli.be_java_hisp_w20_g03.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserService implements IUserService{

    @Autowired
    IUserRepository iUserRepository;

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
    public UserFollowersDTO getFollowedList(int userId) {
        return null;
    }

    @Override
    public boolean unfollow(int userId, int UserIdToUnfollow) {
        return false;
    }
}
