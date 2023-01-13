package com.socialMeli.be_java_hisp_w20_g03.service;

import com.socialMeli.be_java_hisp_w20_g03.dto.UserDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.UserExtendedDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.UserFollowerCountDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.UserFollowersDTO;
import com.socialMeli.be_java_hisp_w20_g03.exception.BadRequestException;
import com.socialMeli.be_java_hisp_w20_g03.exception.NotFoundException;
import com.socialMeli.be_java_hisp_w20_g03.model.User;
import com.socialMeli.be_java_hisp_w20_g03.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository iUserRepository;
    ModelMapper mapper = new ModelMapper();

    @Override
    public List<UserExtendedDTO> getUsers() {
        return iUserRepository.getUsers().stream().map(u -> mapper.map(u, UserExtendedDTO.class)).collect(Collectors.toList());
    }

    @Override
    public String addFollower(int userId, int userIdToFollow) {
        User currentUser = iUserRepository.getUserById(userId);
        User followUser = iUserRepository.getUserById(userIdToFollow);

        if (currentUser == null || followUser == null) {
            throw new NotFoundException("El usuario ingresado no existe");
        }
        List<User> getFollowersList = followUser.getFollowers();
        List<User> getCurrentUserList = currentUser.getFollowed();
        if (getFollowersList.contains(currentUser) || getCurrentUserList.contains(followUser)) {
            throw new BadRequestException("Ya estas siguiendo al usuario: " + followUser.getUserName());
        }
        getFollowersList.add(currentUser);
        getCurrentUserList.add(followUser);
        return "Comenzaste a seguir al usuario: " + followUser.getUserName();
    }

    @Override
    public UserFollowerCountDTO getFollowerCount(int userId) {
        User user = this.iUserRepository.getUserById(userId);

        if (user == null) {
            throw new NotFoundException("El usuario ingresado no existe.");
        }
        int count = user.getFollowers().size();
        return new UserFollowerCountDTO(user.getUserId(), user.getUserName(), count);
    }

    @Override
    public UserFollowersDTO getFollowersList(int userId, String order) {
        User user = iUserRepository.getUserById(userId);

        if (user == null) {
            throw new NotFoundException("El usuario ingresado no existe.");
        }
        List<UserDTO> followers = user.getFollowers().stream()
                .map(u -> mapper.map(u, UserDTO.class)).collect(Collectors.toList());
        if (order != null && order.equals("name_desc")) {
            followers = followers.stream().sorted(Comparator.comparing(x -> x.getUserName(), Comparator.reverseOrder()))
                    .collect(Collectors.toList());
        } else {
            followers = followers.stream().sorted(Comparator.comparing(x -> x.getUserName()))
                    .collect(Collectors.toList());
        }
        return new UserFollowersDTO(user.getUserId(), user.getUserName(), followers);
    }

    @Override
    public UserFollowersDTO getFollowedList(int userId, String order) {
        User user = iUserRepository.getUserById(userId);

        if (user == null) {
            throw new NotFoundException("El usuario ingresado no existe.");
        }
        List<UserDTO> followed = user.getFollowed().stream()
                .map(u -> mapper.map(u, UserDTO.class)).collect(Collectors.toList());
        if (order != null) {
            if (order.equals("name_asc")) {
                followed = followed.stream().sorted(Comparator.comparing(x -> x.getUserName()))
                        .collect(Collectors.toList());
            } else {
                followed = followed.stream().sorted(Comparator.comparing(x -> x.getUserName(), Comparator.reverseOrder()))
                        .collect(Collectors.toList());
            }
        }
        return new UserFollowersDTO(user.getUserId(), user.getUserName(), followed);
    }

    @Override
    public String unfollow(int userId, int userIdToUnfollow) {
        User user = iUserRepository.getUserById(userId);
        User userToUnfollow = iUserRepository.getUserById(userIdToUnfollow);

        if (user == null || userToUnfollow == null) {
            throw new NotFoundException("El usuario ingresado no existe");
        }
        List<User> userFollowedList = user.getFollowed();
        List<User> unfollowedUserFollowerList = userToUnfollow.getFollowers();
        if (!userFollowedList.contains(userToUnfollow) || !unfollowedUserFollowerList.contains(user)) {
            throw new BadRequestException("No esta siguiendo a " + userToUnfollow.getUserName());
        }
        userFollowedList.remove(userToUnfollow);
        unfollowedUserFollowerList.remove(user);
        return "Dejaste de seguir al usuario: " + userToUnfollow.getUserName();
    }
}
