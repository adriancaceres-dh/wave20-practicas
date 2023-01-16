package com.bootcamp.be_java_hisp_w20_g4.service.user;

import com.bootcamp.be_java_hisp_w20_g4.dto.response.user.ListedUserDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.user.UserCountDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.user.UserFollowedDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.user.UserFollowersDTO;
import com.bootcamp.be_java_hisp_w20_g4.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w20_g4.exception.NotFoundException;
import com.bootcamp.be_java_hisp_w20_g4.model.Seller;
import com.bootcamp.be_java_hisp_w20_g4.model.User;
import com.bootcamp.be_java_hisp_w20_g4.repository.user.IUserRepository;
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

    /**
     * Este método realiza el seguimiento de un usuario a un vendedor
     * @param userId - Id del usuario que solicita seguir al vendedor
     * @param userIdToFollow - Id del vendedor que va a ser seguido
     * @return userFollowedDTO - devolvemos al usuario que siguio al vendedor
     */
    public UserFollowedDTO follow (int userId, int userIdToFollow){
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

        List<ListedUserDTO> followed = userFollower.getFollowed().values().stream().map(u->mapper.map(u, ListedUserDTO.class)).collect(Collectors.toList());

        UserFollowedDTO userDto = new UserFollowedDTO(userId,userFollower.getUser_name(),followed);
        return userDto;
    }


    /**
     * Este metodo busca la cantidad de usuarios que siguen al vendedor recibido
     * @param userId - Id del vendedor del que se consulta la cantidad de seguidores
     * @return UserCountDTO - Se devuelve los datos y la cantidad de seguidores del vendedor solicitado
     */
    public UserCountDTO followersCount (int userId){
        User user = userRepository.findById(userId);
        if (user == null){
            throw new NotFoundException("No se ha encontrado el usuario");
        }
        if(!(user instanceof Seller)) throw new BadRequestException("Un comprador no tiene seguidores");
        UserCountDTO userCountDTO = new UserCountDTO(userId,user.getUser_name(),((Seller) user).getFollowers().size());
        return userCountDTO;
    }

    /**
     * Este metodo obtiene la lista de seguidores del vendedor recibido
     * Si el parametro order no es nulo se devuelve alfabeticamente la lista
     * @param userId - Id del usuario del que se quiere obtener la lista de seguidores
     * @param order - Especifica el tipo de ordenamiento que se desea (Opciones aceptadas: "name_asc" , "name_desc", null)
     * @return UserFollowersDTO - Se devuelve los datos del vendedor con su lista de seguidores incluida
     */
    public UserFollowersDTO followers(int userId, String order){
        isValidOrder(order);

        User user = userRepository.findById(userId);
        isValidUser(user);
        isSeller(user);

        if(order == null) return followersUnsorted(user);
        return followersSorted(user, order);

    }

    /**
     * Metodo para obtener la lista de seguidores de un usuario sin ordenar
     * @param user Usuario del que se desea obtener la lista
     * @return UserFollowedDTO - Se devuelve los datos del vendedor con su lista de seguidores desordenada incluida
     */
    private UserFollowersDTO followersUnsorted (User user){
        List<ListedUserDTO> listedUserDTOList = ((Seller) user).getFollowers().values().stream().map(u->mapper.map(u, ListedUserDTO.class)).collect(Collectors.toList());
        return new UserFollowersDTO(user.getUser_id(),user.getUser_name(),listedUserDTOList);
    }

    /**
     * Metodo para obtener la lista de seguidores de un usuario ordenada
     * @param user Usuario del que se desea obtener la lista
     * @param order Especifica el tipo de ordenamiento que se desea (Opciones aceptadas: "name_asc" , "name_desc", null)
     * @return UserFollowedDTO - Se devuelve los datos del vendedor con su lista de seguidores ordenada incluida
     */
    private UserFollowersDTO followersSorted(User user, String order){
        List<ListedUserDTO> listedUserDTOList = ((Seller) user).getFollowers().values().stream().map(u->mapper.map(u, ListedUserDTO.class)).sorted(Comparator.comparing(ListedUserDTO::getUser_name)).collect(Collectors.toList());

        if(order.equals("name_desc")){
            Collections.reverse(listedUserDTOList);
        }
        return new UserFollowersDTO(user.getUser_id(), user.getUser_name(), listedUserDTOList);

    }

    /**
     * Este metodo obtiene la lista de seguidos del usuario recibido
     * Si el parametro order no es nulo se devuelve alfabeticamente la lista
     * @param userId - Id del usuario del que se quiere obtener la lista de seguidos
     * @param order - Especifica el tipo de ordenamiento que se desea (Opciones aceptadas: "name_asc" , "name_desc", null)
     * @return UserFollowersDTO - Se devuelve los datos del usuario con su lista de seguidos incluida
     */
    public UserFollowedDTO followed (int userId, String order){
        isValidOrder(order);

        User user = userRepository.findById(userId);
        isValidUser(user);

        if(order == null) return followedUnsorted(user);
        return followedSorted(user, order);
    }

    /**
     * Metodo para obtener la lista de seguidos de un usuario sin ordenar
     * @param user Usuario del que se desea obtener la lista
     * @return UserFollowedDTO - Se devuelve los datos del usuario con su lista de seguidos desordenada incluida
     */
    private UserFollowedDTO followedUnsorted (User user){
        List<ListedUserDTO> listedUserDTOList = user.getFollowed().values().stream().map(u->mapper.map(u, ListedUserDTO.class)).collect(Collectors.toList());
        return new UserFollowedDTO(user.getUser_id(),user.getUser_name(),listedUserDTOList);
    }

    /**
     * Metodo para obtener la lista de seguidos de un usuario ordenada
     * @param user Usuario del que se desea obtener la lista
     * @param order Especifica el tipo de ordenamiento que se desea (Opciones aceptadas: "name_asc" , "name_desc", null)
     * @return UserFollowedDTO - Se devuelve los datos del usuario con su lista de seguidos ordenada incluida
     */
    private UserFollowedDTO followedSorted(User user, String order){
        List<ListedUserDTO> listedUserDTOList = user.getFollowed().values().stream().map(u->mapper.map(u, ListedUserDTO.class)).sorted(Comparator.comparing(ListedUserDTO::getUser_name)).collect(Collectors.toList());

        if(order.equals("name_desc")){
            Collections.reverse(listedUserDTOList);
        }
        return new UserFollowedDTO(user.getUser_id(), user.getUser_name(), listedUserDTOList);

    }

    /**
     * Este metodo realiza la funcion de dejar de seguira un vendedor
     * @param userId - Id del usuario que desea dejar de seguir al vendedor
     * @param userIdToUnfollow - Id del vendedor que sera dejado de seguir
     * @return UserFollowedDto - Se devuelven los datos del usuario que dejo de seguir con su lista actualizada de seguidos
     */
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
