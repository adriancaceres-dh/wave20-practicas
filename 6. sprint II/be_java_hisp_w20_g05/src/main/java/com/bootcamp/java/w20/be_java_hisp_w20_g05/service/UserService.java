package com.bootcamp.java.w20.be_java_hisp_w20_g05.service;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.MessageExceptionDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowersBySellerDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowersCountDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.UserResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.FollowedListDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions.IdNotFoundException;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions.InvalidFollowUnfollowException;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions.WrongRequestParamException;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.User;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.repository.IRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{
    @Autowired
    private IRepository<User> userRepository;

    private final ModelMapper mapper;

    public UserService() {
        mapper = new ModelMapper();
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    @Override
    public FollowersCountDTO getFollowersCount (int id){
        User user= getById(id);
        return new FollowersCountDTO(user.getId(),user.getFollowers().size(),user.getUserName());
    }

    public User getById(int id) {

        return userRepository.getById(id).orElseThrow(()->new IdNotFoundException(new MessageExceptionDTO("User with id: "+id+" was not found")));
    }

    @Override
    public UserResponseDTO followUser(int userId, int userIdToFollow) {
        User user1 = userRepository.getById(userId)
                .orElseThrow(()->new IdNotFoundException(new MessageExceptionDTO("User with id: "+userId+" was not found")));
        User user2 = userRepository.getById(userIdToFollow)
                .orElseThrow(()->new IdNotFoundException(new MessageExceptionDTO("User with id: "+userIdToFollow+" was not found")));

        if (userId == userIdToFollow)
            throw new InvalidFollowUnfollowException(new MessageExceptionDTO("No puedes seguirte a tí mismo"));

        if (!user1.followUser(user2.getId()))
            throw new InvalidFollowUnfollowException(new MessageExceptionDTO(String.format("Ya sigues al usuario %d", userIdToFollow)));
        user2.addFollower(user1.getId());

        return mapper.map(user2, UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO unfollowUser(int userId, int userIdToUnfollow) {
        User user1 = userRepository.getById(userId)
            .orElseThrow(()->new IdNotFoundException(new MessageExceptionDTO("User with id: "+userId+" was not found")));
        User user2 = userRepository.getById(userIdToUnfollow)
            .orElseThrow(()->new IdNotFoundException(new MessageExceptionDTO("User with id: "+userIdToUnfollow+" was not found")));

        if (!user1.unfollowUser(user2.getId()))
            throw new InvalidFollowUnfollowException(new MessageExceptionDTO(String.format("Actualmente no sigues al usuario %d", userIdToUnfollow)));
        user2.removeFollower(user1.getId());

        return mapper.map(user2, UserResponseDTO.class);
    }

    @Override
    public FollowedListDTO getFollowedListDto(int userId, String order){
        validateOrder(order);

        User user = getById(userId);
        List<UserResponseDTO> followed = new ArrayList<>();
        for(Integer i: user.getFollowing()) followed.add(new UserResponseDTO(i, getById(i).getUserName()));

        orderList(followed,order);

        return new FollowedListDTO(user.getId(), user.getUserName(), followed);
    }

    @Override
    public FollowersBySellerDTO getFollowersBySeller(int userId, String order) {
        validateOrder(order);

        User seller = userRepository.getById(userId).orElseThrow(()->new IdNotFoundException(new MessageExceptionDTO("User with id: "+userId+" was not found")));
        List<User> followers = new ArrayList<>();
        seller.getFollowers()
                .forEach(x ->
                        followers.add(userRepository.getById(x)
                                .orElseThrow(()->new IdNotFoundException(new MessageExceptionDTO("User with id: "+userId+" was not found")))));

        List<UserResponseDTO> followersDto = new ArrayList<>();
        followers.forEach(f -> followersDto.add(new UserResponseDTO(f.getId(),f.getUserName())));

        orderList(followersDto,order);

        return new FollowersBySellerDTO(seller.getId(), seller.getUserName(), followersDto);
    }

    private void orderList(List<UserResponseDTO> userResponseDTOList, String order){
        if (order!=null) {
            userResponseDTOList.sort((x, y) -> (order.equalsIgnoreCase("name_asc")) ?
                    String.CASE_INSENSITIVE_ORDER.compare(x.getUserName(), y.getUserName()) :
                    String.CASE_INSENSITIVE_ORDER.compare(y.getUserName(), x.getUserName()));
        }
    }

    private void validateOrder(String order){
        if(order!=null && !order.equalsIgnoreCase("name_asc") && !order.equalsIgnoreCase("name_desc")){
            throw new WrongRequestParamException(new MessageExceptionDTO("WRONG ORDER PARAMETER"));}
    }

}
