package com.socialmeli.be_java_hisp_w20_g8.repositories.persons;

import com.socialmeli.be_java_hisp_w20_g8.models.Person;
import com.socialmeli.be_java_hisp_w20_g8.models.Seller;
import com.socialmeli.be_java_hisp_w20_g8.models.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PersonRepositoryImp {

    private final Map<String, Set<Person>> persons;

    public PersonRepositoryImp() {
        persons = new HashMap<>(){{
            put("users", new HashSet<>());
            put("sellers", new HashSet<>());
        }};

        loadUsers();
    }

    private boolean loadUsers() {
        persons.get("users").addAll(Set.of(
                new User(1, "user1", new HashSet<>(){{
                    add(3);
                }}),
                new User(2, "user2", new HashSet<>())
        ));
        persons.get("sellers").addAll(Set.of(
                new Seller(3, "seller3", new HashSet<>(), new HashSet<>()),
                new Seller(4, "seller4", new HashSet<>(), new HashSet<>())
        ));
        return true;
    }
    public Set<Integer> getAllFollowed(int userId){
        User user = (User)persons.get("users").stream().filter(u -> u.getId().equals(userId)).findAny().orElse(null);
        return user.getFollowing();
    }
    public Seller findSellerById(Integer id){
        return (Seller)persons.get("sellers").stream().filter(u -> u.getId().equals(id)).findAny().orElse(null);

    }
}
