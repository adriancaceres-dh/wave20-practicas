package com.socialMeli.be_java_hisp_w20_g03.service;

import com.socialMeli.be_java_hisp_w20_g03.dto.UserDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.UserFollowerCountDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.UserFollowersDTO;
import com.socialMeli.be_java_hisp_w20_g03.exception.BadRequestException;
import com.socialMeli.be_java_hisp_w20_g03.exception.NotFoundException;
import com.socialMeli.be_java_hisp_w20_g03.model.User;
import com.socialMeli.be_java_hisp_w20_g03.model.User;
import com.socialMeli.be_java_hisp_w20_g03.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;


@Service
public class UserService implements IUserService{

    @Autowired
    IUserRepository iUserRepository;
    ModelMapper mapper = new ModelMapper();

    @Override
    public List<UserDTO> getUsers() {
        return iUserRepository.getUsers().stream().map(u-> mapper.map(u,UserDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<String> addFollower(int userId, int userIdToFollow) {

        try{
            User currentUser = iUserRepository.getUserById(userId);
            User followUser = iUserRepository.getUserById(userIdToFollow);
            if(currentUser == null || followUser == null)
               throw new NotFoundException("El usuario ingresado no existe");
            List<User> getFollowersList = followUser.getFollowers();
            if(getFollowersList.contains(currentUser))
                throw  new BadRequestException("Ya estas siguiendo al usuario: " + followUser.getUser_name());
            getFollowersList.add(currentUser);
            return new ResponseEntity<>("Comenzaste a seguir al usuario: " + followUser.getUser_name(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public UserFollowerCountDTO getFollowerCount(int userId) {
        return null;
    }

    @Override
    public UserFollowersDTO getFollowersList(int userId, String order) throws NotFoundException{
        //Propuesta: agregar excepcion de user no encontado que responda con bad request asi no se retorna null
        User user = iUserRepository.getUserById(userId);
        if (user == null){
            throw new NotFoundException("El usuario ingresado no existe.");
        }
        List<UserDTO> followers = user.getFollowed().stream()
                .map(u -> mapper.map(u, UserDTO.class)).collect(Collectors.toList());
        if (order != null && order.equals("name_desc")){
            followers = followers.stream().sorted(Comparator.comparing(x -> x.getUser_name(), Comparator.reverseOrder())).collect(Collectors.toList());
        }else{
            followers = followers.stream().sorted(Comparator.comparing(x -> x.getUser_name())).collect(Collectors.toList());
        }
        return new UserFollowersDTO(user.getUser_id(),user.getUser_name(),followers);
    }

    @Override
    public UserFollowersDTO getFollowedList(int userId, String order) {
        User user = iUserRepository.getUserById(userId);
        if (user != null) {
            List<UserDTO> followed = user.getFollowed().stream()
                    .map(u -> mapper.map(u, UserDTO.class)).collect(Collectors.toList());
            if (order != null) {
                if (order.equals("name_asc")){
                    followed = followed.stream().sorted(Comparator.comparing(x -> x.getUser_name())).collect(Collectors.toList());
                }else{
                    followed = followed.stream().sorted(Comparator.comparing(x -> x.getUser_name(), Comparator.reverseOrder())).collect(Collectors.toList());
                }
            }
            return new UserFollowersDTO(user.getUser_id(), user.getUser_name(), followed);
        }
        throw new NotFoundException("El usuario ingresado no existe.");
    }

    @Override
    public boolean unfollow(int userId, int UserIdToUnfollow) {
        return false;
    }
}
