package com.bootcamp.be_java_hisp_w20_g4.service;

import com.bootcamp.be_java_hisp_w20_g4.dto.response.*;
import com.bootcamp.be_java_hisp_w20_g4.excepcion.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g4.excepcion.NotFoundException;
import com.bootcamp.be_java_hisp_w20_g4.model.Seller;
import com.bootcamp.be_java_hisp_w20_g4.model.User;
import com.bootcamp.be_java_hisp_w20_g4.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.bootcamp.be_java_hisp_w20_g4.helpers.user.UserValidator.*;
import static com.bootcamp.be_java_hisp_w20_g4.helpers.Validators.*;

@Service
public class ServiceUsr implements IServiceUsr {

    @Autowired
    IUserRepository userRepository;

     ModelMapper mapper = new ModelMapper();

    public UserDTO follow (int userId, int userIdToFollow){
        isNotSameUser(userId, userIdToFollow);
        User userFollower = userRepository.findById(userId);
        User userFollowed = userRepository.findById(userIdToFollow);
        isValidUser(userFollower);
        isValidUser(userFollowed);
        isSeller(userFollowed);

        if(userFollower.getFollowed().containsKey(userIdToFollow)) throw new BadRequestException("este usuario ya forma parte de sus seguidos");
        userFollower.addUserToMyFollowedList(userFollowed);

        if(((Seller) userFollowed).getFollowers().containsKey(userId)) throw new BadRequestException("Este usuario ya forma parte de tus seguidores");

        ((Seller)userFollowed).addUserToMyFollowersList(userFollower);


        List<ListedUserDTO> followers = ((Seller) userFollowed).getFollowers().values().stream().map(u->mapper.map(u, ListedUserDTO.class)).collect(Collectors.toList());
        List<ListedUserDTO> followed = userFollowed.getFollowed().values().stream().map(u->mapper.map(u, ListedUserDTO.class)).collect(Collectors.toList());
        UserDTO userDto = new UserDTO(userIdToFollow,userFollowed.getUser_name(),followers,followed);
        return userDto;
    }

    public UserCountDTO followersCount (int userId){
        User user = userRepository.findById(userId);
        if (user == null){
            throw new NotFoundException("No se ha encontrado el usuario");
        }
        if(!(user instanceof Seller)) throw new BadRequestException("Un comprador no tiene seguidores");
        UserCountDTO userCountDTO = new UserCountDTO(userId,user.getUser_name(),((Seller) user).getFollowers().size());
        return userCountDTO;
    }

    public UserFollowersDTO followers(int userId, String order){
        isValidOrder(order);

        User user = userRepository.findById(userId);
        isValidUser(user);

        isSeller(user);

        if(order == null) return followersUnsorted(user);
        return followersSorted(user, order);

    }

    private UserFollowersDTO followersUnsorted (User user){
        List<ListedUserDTO> listedUserDTOList = ((Seller) user).getFollowers().values().stream().map(u->mapper.map(u, ListedUserDTO.class)).collect(Collectors.toList());
        return new UserFollowersDTO(user.getUser_id(),user.getUser_name(),listedUserDTOList);
    }

    private UserFollowersDTO followersSorted(User user, String order){
        List<ListedUserDTO> listedUserDTOList = ((Seller) user).getFollowers().values().stream().map(u->mapper.map(u, ListedUserDTO.class)).sorted(Comparator.comparing(ListedUserDTO::getUser_name)).collect(Collectors.toList());

        if(order.equals("name_desc")){
            Collections.reverse(listedUserDTOList);
        }
        return new UserFollowersDTO(user.getUser_id(), user.getUser_name(), listedUserDTOList);

    }
    private UserFollowedDTO followedUnsorted (User user){
        List<ListedUserDTO> listedUserDTOList = user.getFollowed().values().stream().map(u->mapper.map(u, ListedUserDTO.class)).collect(Collectors.toList());
        return new UserFollowedDTO(user.getUser_id(),user.getUser_name(),listedUserDTOList);
    }
    private UserFollowedDTO followedSorted(User user, String order){
        List<ListedUserDTO> listedUserDTOList = user.getFollowed().values().stream().map(u->mapper.map(u, ListedUserDTO.class)).sorted(Comparator.comparing(ListedUserDTO::getUser_name)).collect(Collectors.toList());

        if(order.equals("name_desc")){
            Collections.reverse(listedUserDTOList);
        }
        return new UserFollowedDTO(user.getUser_id(), user.getUser_name(), listedUserDTOList);

    }
    public UserFollowedDTO followed (int userId, String order){
        isValidOrder(order);

        User user = userRepository.findById(userId);
        isValidUser(user);

        if(order == null) return followedUnsorted(user);
        return followedSorted(user, order);
    }

    @Override
    public UserFollowedDTO unfollow(int userId, int userIdToUnfollow) {
        isNotSameUser(userId, userIdToUnfollow);
        User user = userRepository.findById(userId);
        User unfollowUser = userRepository.findById(userIdToUnfollow);

        isValidUser(user);
        isValidUser(unfollowUser);
        isSeller(unfollowUser);
        if(!(user.getFollowed().containsKey(userIdToUnfollow))) throw new BadRequestException("No forma parte de sus seguidos");

        user.removeUserFromMyFollowedList(userIdToUnfollow);

        if(!(((Seller) unfollowUser).getFollowers().containsKey(userId))) throw new BadRequestException("Este usuario no forma parte de tus seguidores");
        ((Seller)unfollowUser).removeUserFromMyFollowersList(userId);

        List<ListedUserDTO> followeds = user.getFollowed().values().stream().map(u->mapper.map(u, ListedUserDTO.class)).collect(Collectors.toList());
        UserFollowedDTO userFollowedDTO= new UserFollowedDTO(userId,user.getUser_name(),followeds);
        return userFollowedDTO;
    }

}
