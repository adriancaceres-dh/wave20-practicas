package com.socialmeli.be_java_hisp_w20_g8.repositories.persons;

import com.socialmeli.be_java_hisp_w20_g8.exceptions.OperationFailedException;
import com.socialmeli.be_java_hisp_w20_g8.models.Person;
import com.socialmeli.be_java_hisp_w20_g8.models.Seller;
import com.socialmeli.be_java_hisp_w20_g8.models.User;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository


public class PersonRepositoryImp implements  PersonRepository{


    private final Map<String, Set<Person>> persons;

    public PersonRepositoryImp() {
        persons = new HashMap<>(){{
            put("users", new HashSet<>());
            put("sellers", new HashSet<>());
        }};

        loadUsers();

    }

    @Override
    public boolean addFollowing(int userId,int sellerId){

        Set<Person> personSet = persons.get("users");
           User person =(User)personSet.stream().filter(p->p.getId()==userId)
                 .findAny().orElseThrow(()-> new OperationFailedException("try to add new follow failed"));
           person.getFollowing().add(sellerId);

        return true;
    }

    @Override
    public boolean addFollower(int sellerId, int userId){

        Set<Person> personSet = persons.get("sellers");
        Seller person =(Seller)personSet.stream().filter(p->p.getId()==sellerId)
                .findAny().orElseThrow(()-> new OperationFailedException("try to add new follower failed"));
        person.getFollowers().add(userId);
        return true;
    }

    @Override
    public boolean checkUser(int userId){
        for (Map.Entry<String, Set<Person>> user : persons.entrySet() ) {
            return user.getValue().stream().anyMatch(currentUser -> currentUser.getId() == userId);

        }
        return false;
    }

    private boolean loadUsers() {
        persons.get("users").addAll(Set.of(
                new User(1, "user1", new HashSet<>()),
                new User(2, "user2", new HashSet<>())
        ));
        persons.get("sellers").addAll(Set.of(
                new Seller(3, "seller3", new HashSet<>(), new HashSet<>()),
                new Seller(4, "seller4", new HashSet<>(), new HashSet<>())
        ));
        return true;

    }

    public Map getSellerByID(int userId){
        checkUser(userId);
        Seller seller = (Seller) persons.get("sellers").stream().filter(person -> persons.get(userId)
    }
}
