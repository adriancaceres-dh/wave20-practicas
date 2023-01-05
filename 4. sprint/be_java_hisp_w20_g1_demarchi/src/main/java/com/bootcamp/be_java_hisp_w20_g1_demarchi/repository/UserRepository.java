package com.bootcamp.be_java_hisp_w20_g1_demarchi.repository;

import com.bootcamp.be_java_hisp_w20_g1_demarchi.Parameter;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.model.User;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.repository.interfaces.IUserRepository;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.util.JsonReaderUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository implements IUserRepository {

    private final List<User> users;

    public UserRepository() {
        this.users = JsonReaderUtil.parseJson(Parameter.getString("UserJsonPath"), User.class);
    }

    @Override
    public boolean isValidId(int id){
        return getUserById(id) != null;
    }

    @Override
    public boolean isSeller(int id){
        return getUserById(id).isSeller();
    }
    @Override
    public User getUserById(int id){
        return users.stream().filter(u -> id == u.getId()).findFirst().orElse(null);
    }

    @Override
    public User addFollower(int userIdToModify, int userIdOfFollower){
        for (User user : users){
            if (user.getId() == userIdToModify){
                user.getFollowers().add(userIdOfFollower);
                return user;
            }
        }
        return null;
    }

    @Override
    public User removeFollower(int userIdToModify, int userIdOfFollower) {
        for (User user : users) {
            if (user.getId() == userIdToModify) {
                 user.getFollowers().remove(userIdOfFollower);
                 return user;
            }
        }
        return null;
    }

    @Override
    public User addFollowed(int userIdToModify, int userIdToFollow){
        for (User user : users){
            if (user.getId() == userIdToModify){
                user.getFollowed().add(userIdToFollow);
                return user;
            }
        }
        return null;
    }

    @Override
    public User removeFollowed(int userIdToModify, int userIdToFollow) {
        for (User user : users) {
            if (user.getId() == userIdToModify) {
                user.getFollowed().remove(userIdToFollow);
                return user;
            }
        }
        return null;
    }
}
