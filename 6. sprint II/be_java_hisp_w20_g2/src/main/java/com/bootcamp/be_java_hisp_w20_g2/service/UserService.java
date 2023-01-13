package com.bootcamp.be_java_hisp_w20_g2.service;

import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserFollowedResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserFollowersCountResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserFollowersResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g2.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w20_g2.model.User;
import com.bootcamp.be_java_hisp_w20_g2.repository.interfaces.IUserRepository;
import com.bootcamp.be_java_hisp_w20_g2.service.interfaces.IUserService;
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

    /**
     * Finds and lists all users following a given user.
     *
     * @param userId the id of the user we are displaying.
     * @param order  indicates the order of the followers list of the user ("name_asc" or "name_desc").
     * @return UserFollowersResponseDTO.
     */
    @Override
    public UserFollowersResponseDTO findAllFollowers(int userId, Optional<String> order) {
        User userFound = userRepository.findOne(userId);
        if (userFound == null) {
            throw new UserNotFoundException("User not found");
        } else {
            List<UserResponseDTO> followers = userFound.getFollowers().stream()
                    .map(user -> new UserResponseDTO(user.getId(), user.getUserName()))
                    .collect(Collectors.toList());
            if (order.isPresent()) {
                Comparator<UserResponseDTO> comparator;
                if (order.get().equals("name_asc")) {
                    comparator = Comparator.comparing(UserResponseDTO::getUserName);
                } else {
                    comparator = Comparator.comparing(UserResponseDTO::getUserName).reversed();
                }

                followers = followers.stream().sorted(comparator).collect(Collectors.toList());

            }
            return new UserFollowersResponseDTO(userFound.getId(), userFound.getUserName(), followers);
        }
    }

    /**
     * Finds and lists all users being followed by a given user.
     *
     * @param userId the id of the user we are displaying.
     * @param order  indicates the order of the followers list of the user ("name_asc" or "name_desc").
     * @return UserFollowedResponseDTO.
     */
    @Override
    public UserFollowedResponseDTO findAllFollowed(int userId, Optional<String> order) {
        User userFound = userRepository.findOne(userId);
        if (userFound == null) {
            throw new UserNotFoundException("User not found");
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

    /**
     * Removes a user from the following list of another user.
     * Removes a user from the followers list of another user.
     *
     * @param userId           the id of the user who is unfollowing the other.
     * @param userIdToUnfollow the id of the user who is being unfollowed.
     */
    @Override
    public String unfollowUser(int userId, int userIdToUnfollow) {

        if (userId != userIdToUnfollow) {
            User user = userRepository.findOne(userId);
            User userToUnfollow = userRepository.findOne(userIdToUnfollow);

            if (user == null) {
                throw new BadRequestException("User not found");
            }
            if (userToUnfollow == null) {
                throw new BadRequestException("User to unfollow not found");
            }

            List<User> userFollowing = user.getFollowing();
            List<User> userFollowers = userToUnfollow.getFollowers();

            if (userFollowing.size() == 0) {
                throw new BadRequestException("This User don't have followings");
            }
            if (userFollowers.size() == 0) {
                throw new BadRequestException("This User don't have followings");
            }

            if (!userFollowing.contains(userToUnfollow) && !userFollowers.contains(user)) {
                throw new BadRequestException("Users no longer follow each other");
            }
            user.removeFollowing(userToUnfollow);
            userToUnfollow.removeFollower(user);

            userRepository.save(user);
            userRepository.save(userToUnfollow);
        } else {
            throw new BadRequestException("You can't unfollow yourself");
        }
        return "Operación exitosa";
    }

    /**
     * Sets the user attribute values into the UserFollowersCountResponseDTO.
     *
     * @param user is the user to get the attribute values from.
     * @return UserFollowersCountResponseDTO.
     */
    public UserFollowersCountResponseDTO entity2UserResponseDTO(User user) {
        UserFollowersCountResponseDTO userFollowersCountResponseDTO = new UserFollowersCountResponseDTO();
        userFollowersCountResponseDTO.setUserId(user.getId());
        userFollowersCountResponseDTO.setUserName(user.getUserName());
        userFollowersCountResponseDTO.setFollowersCount(user.getFollowers().size());
        return userFollowersCountResponseDTO;
    }

    /**
     * Adds a follower into a user followers list.
     * Adds a followed into another user following list.
     *
     * @param idFollower the id of the user who is following the other.
     * @param idFollowed the id of the user who is being followed.
     * @return boolean.
     */
    @Override
    public boolean follow(Integer idFollower, Integer idFollowed) {
        if (!userRepository.exists(idFollowed) || !userRepository.exists(idFollower)) {
            throw new BadRequestException("Alguno de los usuarios no existe");
        }
        User follower = userRepository.findOne(idFollower);
        User followed = userRepository.findOne(idFollowed);
        if (follower.getFollowing().contains(followed)) {
            throw new BadRequestException("Ya esta siguiendo a ese usuario");
        }
        if (follower.equals(followed)) {
            throw new BadRequestException("No puedes seguirte a ti mismo");
        }
        follower.follow(followed);
        followed.addFollower(follower);
        return true;
    }

    /**
     * Takes an id, finds the user of the given id and uses the entity2UserResponseDTO() method
     * to return a UserFollowersCountResponseDTO.
     *
     * @param id the id of the user who is unfollowing the other.
     * @return UserFollowersCountResponseDTO.
     */
    @Override
    public UserFollowersCountResponseDTO followerList(Integer id) {
        if (!userRepository.exists(id)) {
            throw new BadRequestException("El usuario no existe");
        }
        User user = userRepository.findOne(id);
        return entity2UserResponseDTO(user);
    }


}
