package com.bootcamp.be_java_hisp_w20_g2_alderete.service;

import com.bootcamp.be_java_hisp_w20_g2_alderete.dto.response.UserFollowedResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_alderete.dto.response.UserFollowersCountResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_alderete.dto.response.UserFollowersResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_alderete.dto.response.UserResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_alderete.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g2_alderete.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w20_g2_alderete.model.User;
import com.bootcamp.be_java_hisp_w20_g2_alderete.repository.interfaces.IUserRepository;
import com.bootcamp.be_java_hisp_w20_g2_alderete.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserFollowersResponseDTO findAllFollowers(int userId, Optional<String> order) {
        User userFound = userRepository.findOne(userId);
        if (userFound == null) {
            throw new UserNotFoundException("Usuario no encontrado.");
        } else {
            List<UserResponseDTO> followers = userFound.getFollowers().stream()
                    .map(user -> new UserResponseDTO(user.getId(), user.getUserName()))
                    .collect(Collectors.toList());
            if (order.isPresent()) {
                Comparator<UserResponseDTO> comparator;
                if (order.get().equals("name_asc") || order.get().equals("name_desc")) {
                    comparator = Comparator.comparing(UserResponseDTO::getUserName);
                } else {
                    comparator = Comparator.comparing(UserResponseDTO::getUserName).reversed();
                }

                followers = followers.stream().sorted(comparator).collect(Collectors.toList());

            }
            return new UserFollowersResponseDTO(userFound.getId(), userFound.getUserName(), followers);
        }
    }

    @Override
    public UserFollowedResponseDTO findAllFollowed(int userId, Optional<String> order) {
        User userFound = userRepository.findOne(userId);
        if (userFound == null) {
            throw new UserNotFoundException("Usuario no encontrado.");
        } else {
            List<UserResponseDTO> followed = userFound.getFollowing().stream()
                    .map(user -> new UserResponseDTO(user.getId(), user.getUserName()))
                    .collect(Collectors.toList());
            if (order.isPresent()) {
                if (order.get().equals("name_asc") || order.get().equals("name_desc")) {
                    Comparator<UserResponseDTO> comparator;
                    if (order.get().equals("name_asc")) {
                        comparator = Comparator.comparing(UserResponseDTO::getUserName);
                    } else {
                        comparator = Comparator.comparing(UserResponseDTO::getUserName).reversed();
                    }
                    followed = followed.stream().sorted(comparator).collect(Collectors.toList());
                }

            }
            return new UserFollowedResponseDTO(userFound.getId(), userFound.getUserName(), followed);
        }
    }

    @Override
    public void unfollowUser(int userId, int userIdToUnfollow) {

        if (userId != userIdToUnfollow) {
            User user = userRepository.findOne(userId);
            User userToUnfollow = userRepository.findOne(userIdToUnfollow);

            if (user == null) {
                throw new BadRequestException("Usuario no encontrado.");
            }
            if (userToUnfollow == null) {
                throw new BadRequestException("Usuario no encontrado.");
            }

            List<User> userFollowing = user.getFollowing();
            List<User> userFollowers = userToUnfollow.getFollowers();

            if (userFollowing.size() == 0) {
                throw new BadRequestException("Este usuario no sigue a nadie.");
            }
            if (userFollowers.size() == 0) {
                throw new BadRequestException("Este usuario no sigue a nadie.");
            }

            if (!userFollowing.contains(userToUnfollow) && !userFollowers.contains(user)) {
                throw new BadRequestException("Los usuarios ya no se siguen entre si.");
            }
            user.removeFollowing(userToUnfollow);
            userToUnfollow.removeFollower(user);

            userRepository.save(user);
            userRepository.save(userToUnfollow);
        } else {
            throw new BadRequestException("No puedes realizar esa acción.");
        }
    }


    public UserFollowersCountResponseDTO entity2UserResponseDTO(User user) {
        UserFollowersCountResponseDTO userFollowersCountResponseDTO = new UserFollowersCountResponseDTO();
        userFollowersCountResponseDTO.setUserId(user.getId());
        userFollowersCountResponseDTO.setUserName(user.getUserName());
        userFollowersCountResponseDTO.setFollowersCount(user.getFollowers().size());
        return userFollowersCountResponseDTO;
    }

    @Override
    public boolean follow(Integer idFollower, Integer idFollowed) {
        if (!userRepository.exists(idFollowed) || !userRepository.exists(idFollower)) {
            throw new BadRequestException("Alguno de los usuarios no existe.");
        }
        User follower = userRepository.findOne(idFollower);
        User followed = userRepository.findOne(idFollowed);
        if (follower.getFollowing().contains(followed)) {
            throw new BadRequestException("Ya esta siguiendo a ese usuario.");
        }
        if (follower.equals(followed)) {
            throw new BadRequestException("No puedes seguirte a ti mismo.");
        }
        follower.follow(followed);
        followed.addFollower(follower);
        return true;
    }

    @Override
    public UserFollowersCountResponseDTO followerList(Integer id) {
        if (!userRepository.exists(id)) {
            throw new BadRequestException("El usuario no existe.");
        }
        User user = userRepository.findOne(id);
        return entity2UserResponseDTO(user);
    }

}
