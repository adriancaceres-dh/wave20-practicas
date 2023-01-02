package com.bootcamp.be_java_hisp_w20_g4.model;

import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
public class User {
    private int user_id;
    private String user_name;
    private HashMap<Integer, User> followers = new HashMap<>();
    private HashMap<Integer, User> followed = new HashMap<>();
    private HashMap<Integer, Publication> publications = new HashMap<>();

    /**
     * el propio usuario agrega en su lista de seguidos (followed) la persona a la que siguió
      * @param userToFollow
     * @return
     */
    public User addUserToMyFollowedList(User userToFollow){
        if(followed.containsKey(userToFollow.getUser_id())){
            return null; // lanza excepcion porque ya lo sigue
        }else{
            followed.put(userToFollow.getUser_id(), userToFollow);
            return userToFollow;
        }
    }

    /**
     * el propio usuario agrega en su lista de seguidores (followers) la persona que lo siguió
     * @param userToFollowed
     * @return
     */
    public User addUserToMyFollowersList(User userToFollowed){
        if(followers.containsKey(userToFollowed.getUser_id())){
            return null; // lanza excepcion porque ya es seguido
        }else{
            followers.put(userToFollowed.getUser_id(), userToFollowed);
            return userToFollowed;
        }
    }

    // TODO: 29/12/22  
    private User unFollowSeller(User userToUnFollow){
        if(followers.containsKey(userToUnFollow.getUser_id())){
            followers.remove(userToUnFollow.getUser_id());
            return userToUnFollow;
        }else{
            return null;// lanza excepcion porque no sigue al usuario
        }
    }
    

    private List<Publication> getPublicationLast2Week(){
        return null;
    }

    private List<Product> obtainProductsWithDiscount(){
        return null;
    }

}
