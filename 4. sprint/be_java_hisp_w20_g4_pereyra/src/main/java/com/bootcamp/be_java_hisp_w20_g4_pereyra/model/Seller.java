package com.bootcamp.be_java_hisp_w20_g4_pereyra.model;


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

    /**
     * Este método obtiene la cantidad de seguidores que tiene el vendedor
     * @return int - Devuelve la cantidad de seguidores
     */
    private int getCountFollowers(){
        return this.getFollowers().size();
    }


    /**
     * Este método agrega una publicación a la lista de publicaciones
     * @param publicationToAdd - Es la publicación que hay que agregar
     * @return Publication - Devuelve la publicación agregada
     */
    public Publication addPublication(Publication publicationToAdd){
        if(this.publications.containsKey(publicationToAdd)){
            return null;
        }else{
            this.publications.put(publicationToAdd.getPost_id(), publicationToAdd);
            return publicationToAdd;
        }
    }

    /**
     * El propio usuario agrega en su lista de seguidores (followers) la persona que lo siguió
     * @param userToFollowed - Es el usuario al que hay que agregar a la lista
     * @return User - Devuelve el usuario al que se siguió
     */
    public User addUserToMyFollowersList(User userToFollowed){
        if(followers.containsKey(userToFollowed.getUser_id())){
            return null;
        }else{
            followers.put(userToFollowed.getUser_id(), userToFollowed);
            return userToFollowed;
        }
    }

    /**
     * Este método elimina de la lista de seguidos al usuario recibido
     * @param userToUnFollow - Es el usuario que hay que eliminar
     * @return User - Devuelve el usuario que se dejó de seguir
     */
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
