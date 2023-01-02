package com.bootcamp.java.w20.be_java_hisp_w20_g05.service;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.MessageExceptionDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowersBySellerDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowersCountDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.UserResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.FollowedListDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions.IdNotFoundException;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.User;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{
    @Autowired
    private IRepository<User> userRepository;

    @Override
    public List<UserResponseDTO> filterBy(String name) {
        return null;
    }


    public FollowersCountDTO getFollowersCount (int id){
        User user= userRepository.getAll().stream()
                .filter(u -> u.getId()==id)
                .findFirst()
                .orElse(null);
        if(user==null) throw new IdNotFoundException(new MessageExceptionDTO("USER NOT FOUND"));
        return new FollowersCountDTO(user.getId(),user.getFollowers().size(),user.getUserName());
    }

    public List<User> getAll(){return new ArrayList<>(userRepository.getAll());}

    public User getById(int id) {
        return userRepository.getById(id);
    }

    @Override
    public boolean followUser(int userId, int userIdToFollow) {

        try {
            User user1 = userRepository.getById(userId);
            User user2 = userRepository.getById(userIdToFollow);
            user1.followUser(user2.getId());
            user2.addFollower(user1.getId());
        } catch (IdNotFoundException exception) {
            return false;
        }

        return true;
    }

    @Override
    public boolean unfollowUser(int userId, int userIdToUnfollow) {
        try {
            User user1 = userRepository.getById(userId);
            User user2 = userRepository.getById(userIdToUnfollow);
            user1.unfollowUser(user2.getId());
            user2.removeFollower(user1.getId());
        } catch (IdNotFoundException exception) {
            return false;
        }
        return true;
    }

    @Override
    public FollowedListDTO getFollowedListDto(int userId){
        User user = getById(userId);
        FollowedListDTO followedList = new FollowedListDTO(user.getId(), user.getUserName());
        for(Integer i: user.getFollowing()) followedList.followed.add(new UserResponseDTO(i, getById(i).getUserName()));
        return followedList;
    }

    @Override
    public FollowersBySellerDTO getFollowersBySeller(int userId)
    {
        User seller = userRepository.getById(userId);

        List<User> followers = new ArrayList<>();
        seller.getFollowers().stream().forEach(x -> followers.add(userRepository.getById(x)));

        List<UserResponseDTO> followersDto = new ArrayList<>();
        followers.stream().forEach(f -> followersDto.add(new UserResponseDTO(f.getId(),f.getUserName())));

        return new FollowersBySellerDTO(seller.getId(), seller.getUserName(), followersDto);
    }

}
