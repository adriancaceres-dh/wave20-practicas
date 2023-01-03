package com.bootcamp.be_java_hisp_w20_g4.repository.user;


import com.bootcamp.be_java_hisp_w20_g4.model.Buyer;
import com.bootcamp.be_java_hisp_w20_g4.model.Seller;
import com.bootcamp.be_java_hisp_w20_g4.model.User;
import com.bootcamp.be_java_hisp_w20_g4.repository.user.IUserRepository;
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

    public User findById(int idUser){
        return users.stream().filter(x->x.getUser_id() == idUser).findFirst().orElse(null);
    }

}
