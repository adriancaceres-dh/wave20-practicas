package com.bootcamp.be_java_hisp_w20_g4.service;

import com.bootcamp.be_java_hisp_w20_g4.dto.response.ListedUserDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.UserCountDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.UserDTO;
import com.bootcamp.be_java_hisp_w20_g4.excepcion.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g4.excepcion.NotFoundException;
import com.bootcamp.be_java_hisp_w20_g4.model.User;
import com.bootcamp.be_java_hisp_w20_g4.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceUsr implements IServiceUsr {

    @Autowired
    IUserRepository userRepository;

     ModelMapper mapper = new ModelMapper();

    public UserCountDTO followersCount(int userId){
        return null;
    }

    public UserDTO followers(int userId){
        return null;
    }

    public UserDTO follow (int userId, int userIdToFollow){
        if(userId == userIdToFollow){
            throw new BadRequestException("El usuario no puede ser seguido por el mismo");
        }
        User userFollower = userRepository.findById(userId);
        User userFollowed = userRepository.findById(userIdToFollow);
        if(userFollower == null || userFollowed == null){
            throw new NotFoundException("No se ha encontrado el usuario");
        }
        if(userFollower.followSeller(userFollowed) == null){
            throw new NotFoundException("El usuario ya es seguido por el seguidor");
        }
        if(userFollowed.followedSeller(userFollower) == null){
            throw new NotFoundException("El seguidor ya sigue al usuario");
        }
        List<ListedUserDTO> aux = userFollower.getFollowers().values().stream().map(u->mapper.map(u, ListedUserDTO.class)).collect(Collectors.toList());
        UserDTO userDto = new UserDTO(userId,userFollower.getUser_name(),aux);
        return userDto;
    }

}
