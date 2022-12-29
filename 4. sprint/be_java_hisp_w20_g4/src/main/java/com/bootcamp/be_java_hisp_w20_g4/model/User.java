package com.bootcamp.be_java_hisp_w20_g4.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public abstract class User {
    private int id;
    private String userName;
    private HashMap<Integer, User> followers = new HashMap<>();
    private HashMap<Integer, User> followed = new HashMap<>();
    private HashMap<Integer,Publication> publicactions = new HashMap<>();

    // TODO: 29/12/22  
    private User followSeller(User userToFollow){
        if(followers.containsKey(userToFollow.getId())){
            return null; // lanza excepcion porque ya lo sigue
        }else{
            followers.put(userToFollow.getId(), userToFollow);
            return userToFollow;
        }
    }

    // TODO: 29/12/22  
    private User unFollowSeller(User userToUnFollow){
        if(followers.containsKey(userToUnFollow.getId())){
            followers.remove(userToUnFollow.getId());
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
