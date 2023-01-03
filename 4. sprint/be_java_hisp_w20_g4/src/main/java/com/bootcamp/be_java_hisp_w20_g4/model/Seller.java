package com.bootcamp.be_java_hisp_w20_g4.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seller extends User{
    private HashMap<Integer, Publication> publications;
    private HashMap<Integer, User> followers;

    public Seller(int id, String userName) {
        super(id, userName, new HashMap<>());
        this.followers = new HashMap<>();
        this.publications = new HashMap<>();
    }

    private int getCountFollowers(){
        return this.getFollowers().size();
    }

    // TODO: 29/12/22
    public Publication addPublication(Publication publicationToAdd){
        if(this.publications.containsKey(publicationToAdd)){
            return null; // ya existe la publicacion tiene que lanzar una excepcion
        }else{
            this.publications.put(publicationToAdd.getPost_id(), publicationToAdd);
            return publicationToAdd;
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
    public User unFollowSeller(User userToUnFollow){
        if(followers.containsKey(userToUnFollow.getUser_id())){
            followers.remove(userToUnFollow.getUser_id());
            return userToUnFollow;
        }else{
            return null;// lanza excepcion porque no sigue al usuario
        }
    }

    private List<Product> obtainProductsWithDiscount(){
        return null;
    }

    public User removeUserFromMyFollowersList(int userId) {
        return followers.remove(userId);
    }
}
