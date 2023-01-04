package com.bootcamp.java.w20.be_java_hisp_w20_g05.service;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.MessageExceptionDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowersListDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowersCountDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.UserResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowingListDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions.InvalidFollowUnfollowException;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions.WrongRequestParamException;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.User;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService{
    @Autowired
    private IRepository<User> userRepository;

    @Override
    public FollowersCountDTO getFollowersCount (int id){
        User user = userRepository.getBy(id);
        return new FollowersCountDTO(user.getId(), user.getUserName(), user.getFollowers().size());
    }

    @Override
    public boolean followUser(int userId, int userIdToFollow) {
        if (userId == userIdToFollow)
            throw new InvalidFollowUnfollowException(new MessageExceptionDTO("No puedes seguirte a tí mismo"));

        User user1 = userRepository.getBy(userId);
        User user2 = userRepository.getBy(userIdToFollow);

        if (!user1.followUser(user2.getId()))
            throw new InvalidFollowUnfollowException(new MessageExceptionDTO(String.format("Ya sigues al usuario %d", userIdToFollow)));
        return user2.addFollower(user1.getId());
    }

    @Override
    public boolean unfollowUser(int userId, int userIdToUnfollow) {
        User user1 = userRepository.getBy(userId);
        User user2 = userRepository.getBy(userIdToUnfollow);

        if (!user1.unfollowUser(user2.getId()))
            throw new InvalidFollowUnfollowException(new MessageExceptionDTO(String.format("Actualmente no sigues al usuario %d", userIdToUnfollow)));
        return user2.removeFollower(user1.getId());
    }

    @Override
    public FollowingListDTO getFollowingList(int userId, String order){
        User user = userRepository.getBy(userId);
        List<UserResponseDTO> followed = new ArrayList<>();
        for(Integer i: user.getFollowing()) followed.add(new UserResponseDTO(i, userRepository.getBy(i).getUserName()));

        orderList(followed,order);

        return new FollowingListDTO(user.getId(), user.getUserName(), followed);
    }

    @Override
    public FollowersListDTO getFollowersList(int userId, String order) {
        User seller = userRepository.getBy(userId);
        List<User> followers = new ArrayList<>();
        seller.getFollowers().forEach(x -> followers.add(userRepository.getBy(x)));

        List<UserResponseDTO> followersDto = new ArrayList<>();
        followers.forEach(f -> followersDto.add(new UserResponseDTO(f.getId(),f.getUserName())));

        orderList(followersDto,order);

        return new FollowersListDTO(seller.getId(), seller.getUserName(), followersDto);
    }

    public void orderList(List<UserResponseDTO> userResponseDTOList, String order){
        if (order != null) {
            validateOrder(order);
            userResponseDTOList.sort((x, y) -> (order.equalsIgnoreCase("name_asc")) ?
                    String.CASE_INSENSITIVE_ORDER.compare(x.getUserName(), y.getUserName()) :
                    String.CASE_INSENSITIVE_ORDER.compare(y.getUserName(), x.getUserName()));
        }
    }

    public void validateOrder(String order){
        if (!order.equalsIgnoreCase("name_asc") && !order.equalsIgnoreCase("name_desc"))
            throw new WrongRequestParamException(new MessageExceptionDTO("WRONG ORDER PARAMETER"));
    }

}
