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

import static com.bootcamp.be_java_hisp_w20_g4.helpers.Validators.*;

@Service
public class ServiceUsr implements IServiceUsr {

    @Autowired
    IUserRepository userRepository;

     ModelMapper mapper = new ModelMapper();

    public UserDTO follow (int userId, int userIdToFollow){
        if(userId == userIdToFollow){
            throw new BadRequestException("El usuario no puede ser seguido por el mismo");
        }
        User userFollower = userRepository.findById(userId);
        User userFollowed = userRepository.findById(userIdToFollow);
        if(userFollower == null || userFollowed == null){
            throw new NotFoundException("No se ha encontrado el usuario");
        }
        if(!(userFollowed instanceof Seller)) throw new BadRequestException("No se puede seguir a un comprador.");
        if(userFollower.addUserToMyFollowedList(userFollowed) == null){
            throw new NotFoundException("El usuario ya es seguido por el seguidor");
        }
        if(((Seller)userFollowed).addUserToMyFollowersList(userFollower) == null){
            throw new NotFoundException("El seguidor ya sigue al usuario");
        }
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

}
