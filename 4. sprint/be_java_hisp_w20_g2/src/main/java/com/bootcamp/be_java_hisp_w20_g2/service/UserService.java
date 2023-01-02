package com.bootcamp.be_java_hisp_w20_g2.service;


import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserFollowersResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g2.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w20_g2.model.User;
import com.bootcamp.be_java_hisp_w20_g2.repository.interfaces.IUserRepository;
import com.bootcamp.be_java_hisp_w20_g2.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserFollowersResponseDTO findAllFollowers(int userId) {
        User userFound = userRepository.findOne(userId);
        if (userFound == null) {
            throw new UserNotFoundException("User not found");
        } else {
            List<UserResponseDTO> followers = userFound.getFollowers().stream().map(user -> new UserResponseDTO(user.getId(), user.getUserName())).collect(Collectors.toList());
            //^^^^^^ podría hacerse con un mapper ^^^^^^
            return new UserFollowersResponseDTO(userFound.getId(), userFound.getUserName(), followers);
        }
    }

    @Override
    public void unfollowUser(int userId, int userIdToUnfollow) {
        User user = userRepository.findOne(userId);
        User userToUnfollow = userRepository.findOne(userIdToUnfollow);

        //Checkeo que existan los usuarios, si alguno no existe lanzo la excepcion correspondiente
        if (user == null) {
            throw new BadRequestException("Usuario no encontrado");
        }
        if (userToUnfollow == null) {
            throw new BadRequestException("Usuario a dejar de seguir no encontrado");
        }

        // Listas Auxiliares
        List<User> userFollowing = user.getFollowing();
        List<User> userFollowers = userToUnfollow.getFollowers();

        //Checkeo que las listas no esten vacias, lanzo excepcion en caso que lo estén
        if (userFollowing.size() == 0) {
            throw new BadRequestException("El usuario no sigue a nadie");
        }
        if (userFollowers.size() == 0) {
            throw new BadRequestException("El usuario no tiene seguidores");
        }

        //Si las listan no están vacias hago la modificación correspondiente
        user.removeFollowing(userToUnfollow);
        userToUnfollow.removeFollower(user);

        //Actualizo los usuarios en el repo con los cambios hechos
        userRepository.save(user);
        userRepository.save(userToUnfollow);
    }

}
