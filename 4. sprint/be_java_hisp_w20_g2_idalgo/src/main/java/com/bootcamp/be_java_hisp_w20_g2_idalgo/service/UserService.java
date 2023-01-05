package com.bootcamp.be_java_hisp_w20_g2_idalgo.service;

import com.bootcamp.be_java_hisp_w20_g2_idalgo.dto.UserDTO;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.dto.response.UserFollowedResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.dto.response.UserFollowersCountResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.dto.response.UserFollowersResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.model.User;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.repository.interfaces.IUserRepository;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.service.interfaces.IUserService;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.utils.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService implements IUserService {

    private final List<String> validUserSort = List.of("name_asc", "nameDesc");
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

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
            List<UserDTO> followers = userFound.getFollowers().stream()
                    .map(user -> new UserDTO(user.getId(), user.getUserName()))
                    .collect(Collectors.toList());
            if (order.isPresent()) {
                followers = followers.stream().sorted(getUserComparator(order.get())).collect(Collectors.toList());

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
        }
        Stream<UserDTO> followed = userFound.getFollowing().stream()
                .map(user -> new UserDTO(user.getId(), user.getUserName()));
        if (order.isPresent() && validUserSort.contains(order.get())) {
            followed = followed.sorted(getUserComparator(order.get()));
        }
        return new UserFollowedResponseDTO(userFound.getId(), userFound.getUserName(), followed.collect(Collectors.toList()));

    }

    /**
     * Removes a user from the following list of another user.
     * Removes a user from the followers list of another user.
     *
     * @param userId           the id of the user who is unfollowing the other.
     * @param userIdToUnfollow the id of the user who is being unfollowed.
     */
    @Override
    public void unfollowUser(int userId, int userIdToUnfollow) {

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
                throw new BadRequestException("This User don't have followers");
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
            throw new BadRequestException("One of the users does not exist");
        }
        User follower = userRepository.findOne(idFollower);
        User followed = userRepository.findOne(idFollowed);
        if (follower.getFollowing().contains(followed)) {
            throw new BadRequestException("Already following that user");
        }
        if (follower.equals(followed)) {
            throw new BadRequestException("Can't follow yourself");
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
            throw new BadRequestException("The user does not exist");
        }
        User user = userRepository.findOne(id);
        return userMapper.toCountDTO(user);
    }

    private Comparator<UserDTO> getUserComparator(String criteria) {
        Comparator<UserDTO> comparator = Comparator.comparing(UserDTO::getUserName);

        return criteria.equals("name_asc") ? comparator : comparator.reversed();
    }

}
