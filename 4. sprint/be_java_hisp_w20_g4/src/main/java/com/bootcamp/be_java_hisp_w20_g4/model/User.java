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

    // TODO: 29/12/22  
    public User followSeller(User userToFollow){
        if(followers.containsKey(userToFollow.getUser_id())){
            return null; // lanza excepcion porque ya lo sigue
        }else{
            followers.put(userToFollow.getUser_id(), userToFollow);
            return userToFollow;
        }
    }

    public User followedSeller(User userToFollowed){
        if(followed.containsKey(userToFollowed.getUser_id())){
            return null; // lanza excepcion porque ya es seguido
        }else{
            followed.put(userToFollowed.getUser_id(), userToFollowed);
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
