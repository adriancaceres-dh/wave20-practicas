package com.bootcamp.be_java_hisp_w20_g4_stocco.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class User {
    private int user_id;
    private String user_name;
    private HashMap<Integer, User> followed = new HashMap<>();

    /**
     * El propio usuario agrega en su lista de seguidos (followed) la persona a la que siguió
      * @param userToFollow - Es el usuario que hay que agregar a mis seguidos
     * @return User - Devuelve el usuario agregado
     */
    public User addUserToMyFollowedList(User userToFollow){
            return followed.put(userToFollow.getUser_id(), userToFollow);
    }

    /**
     * El propio usuario elimina de su lista de seguidos (followed) la persona a la que dejo de seguir
     * @param userToUnfollow - Es el usuario que hay que agregar a mis seguidos
     * @return User - Devuelve el usuario eliminado
     */
    public User removeUserFromMyFollowedList(int userIdToUnfollow){
        return followed.remove(userIdToUnfollow);
    }
}
