package com.bootcamp.be_java_hisp_w20_g4_pereyra.repository.user;


import com.bootcamp.be_java_hisp_w20_g4_pereyra.model.Buyer;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.model.Seller;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {

    private List<User> users;

    public UserRepository(){
        users = loadUsers();
    }

    private List<User> loadUsers() {
        users = new ArrayList<>();
        users.add(new Seller(1,"rodri"));
        users.add(new Seller(2,"ivan"));
        users.add(new Seller(3,"emi"));
        users.add(new Buyer(4,"gabi"));
        users.add(new Buyer(5,"joaco"));
        users.add(new Buyer(6,"tammi"));
        users.add(new Seller(7,"martin"));
        return users;
    }
    /**
     * Este método busca un usuario que coincida con el id recibido
     * Si ninguno coincide se devuelve null
     * @param idUser - Id del usuario que se desea buscar
     * @return User - Se devuelve la informacion del usuario buscado
     */
    public User findById(int idUser){
        return users.stream().filter(x->x.getUser_id() == idUser).findFirst().orElse(null);
    }

}
