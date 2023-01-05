package com.socialmeli.be_java_hisp_w20_g8.repositories.persons;

import com.socialmeli.be_java_hisp_w20_g8.exceptions.NotFoundException;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.OperationFailedException;
import com.socialmeli.be_java_hisp_w20_g8.models.Person;
import com.socialmeli.be_java_hisp_w20_g8.models.Seller;
import com.socialmeli.be_java_hisp_w20_g8.models.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository

public class PersonRepositoryImp implements IPersonRepository {


    private final Map<String, Set<Person>> persons;

    public PersonRepositoryImp() {
        persons = new HashMap<>() {{
            put("users", new HashSet<>());
            put("sellers", new HashSet<>());
        }};

        loadUsers();
    }

    @Override
    public boolean addFollowing(int userId, int sellerId) {

        Set<Person> personSet = persons.get("users");
        User person = (User) personSet.stream().filter(p -> p.getId() == userId)
                .findAny().orElseThrow(() -> new OperationFailedException("try to add new follow failed"));
        person.getFollowing().add(sellerId);

        return true;
    }

    @Override
    public boolean addFollower(int sellerId, int userId) {

        Set<Person> personSet = persons.get("sellers");
        Seller person = (Seller) personSet.stream().filter(p -> p.getId() == sellerId)
                .findAny().orElseThrow(() -> new OperationFailedException("try to add new follower failed"));
        person.getFollowers().add(userId);
        return true;
    }

    @Override
    public boolean checkUser(int userId) {
        for (Map.Entry<String, Set<Person>> user : persons.entrySet()) {
            if (user.getValue().stream().anyMatch(currentUser -> currentUser.getId() == userId)){
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean unfollowing(int userId, int sellerId) {
        Set<Person> personSet = persons.get("users");
        User person = (User) personSet.stream().filter(p -> p.getId() == userId)
                .findAny().orElseThrow(() -> new OperationFailedException("follower removal failed"));
        if (person.getFollowing().contains(sellerId)) {
            person.getFollowing().remove(sellerId);
            return true;
        } else return false;
    }

    @Override
    public boolean unfollower(int sellerId, int userId) {
        Set<Person> personSet = persons.get("sellers");
        Seller person = (Seller) personSet.stream().filter(p -> p.getId() == sellerId)
                .findAny().orElseThrow(() -> new OperationFailedException("follower removal failed"));
        if (person.getFollowers().contains(userId)) {
            person.getFollowers().remove(userId);
            return true;
        } else return false;
    }

    private boolean loadUsers() {
        persons.get("users").addAll(Set.of(

                new User(1, "user1", new HashSet<>(){{
                    add(5);
                    add(6);
                    add(9);
                }}),
                new User(2, "user2", new HashSet<>(){{
                    add(9);
                    add(10);
                }}),
                new User(3, "ghds", new HashSet<>(){{
                    add(9);
                }}),
                new User(4, "zdsfg", new HashSet<>())
        ));
        persons.get("sellers").addAll(Set.of(
                new Seller(5, "seller3", new HashSet<>(){{
                    add(1);
                }}, new HashSet<>(){{
                    add(1);
                    add(2);
                    add(5);
                }}),
                new Seller(6, "seller4", new HashSet<>(){{
                    add(1);
                }}, new HashSet<>(){{
                    add(4);
                }}),
                new Seller(7, "seller3", new HashSet<>(), new HashSet<>(){{
                    add(3);
                }}),
                new Seller(8, "seller4", new HashSet<>(), new HashSet<>()),

                new Seller(9, "zxc", new HashSet<>(){{
                    add(1);
                    add(2);
                    add(3);
                }}, new HashSet<>()),
                new Seller(10, "hjf", new HashSet<>(){{
                    add(2);
                }}, new HashSet<>())
        ));
        return true;
    }

    public Set<Integer> getAllFollowed(int userId) {
        User user = (User) persons.get("users").stream().filter(u -> u.getId().equals(userId)).findAny().orElseThrow(()-> new NotFoundException("Doesn't exist user"));
        return user.getFollowing();
    }


    public Seller findSellerById(Integer id) {
        return (Seller) persons.get("sellers").stream().filter(u -> u.getId().equals(id)).findAny().orElseThrow(()-> new NotFoundException("Doesn't exist seller"));

    }

    @Override
    public User findUserById(Integer id) {
        return (User) persons.get("users").stream().filter(u -> u.getId().equals(id)).findAny().orElseThrow(()-> new NotFoundException("Doesn't exist user"));
    }

    public Seller getById(int id){
        return (Seller) persons.get("sellers").stream().filter(x->x.getId()==id).findFirst().orElseThrow(()-> new NotFoundException("Doesn't exist id"));
    }

    public Set<Integer> GetSellerFollowers(int userId){
        Seller seller = findSellerById(userId);
        if(seller==null){
            return null;
        }else{
            return seller.getFollowers();
        }
    }

}
