package com.socialmeli.be_java_hisp_w20_g8.services.sellers;

import com.socialmeli.be_java_hisp_w20_g8.exceptions.NotFoundException;
import com.socialmeli.be_java_hisp_w20_g8.models.Seller;
import com.socialmeli.be_java_hisp_w20_g8.models.User;
import com.socialmeli.be_java_hisp_w20_g8.repositories.persons.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SellerService implements ISellerService{

    @Autowired
    static
    PersonRepository personRepository;

    /*
    public List<Seller> searhSeller(Integer sellerId){
        System.out.println("_______________- Entre_________________");


        //Contar numero de followers del getSeller
         SellerDTO person = (SellerDTO) personRepositoryImp.getSellers().stream().filter(p->p.getId()==sellerId);

        //String num= String.valueOf(person.getFollowers().size());

        String sel = person.toString();

        System.out.println("------------------------------------ "+ sel);

        //Aqui hago el filtro por seller
        //return personRepositoryImp.getSellers().stream().filter(a->a.getId()==sellerId).collect(Collectors.toList()).toString();
        return sel;





    }

*/

    public List<User> countUser(int userId){


        Set<Integer> followedUsers = personRepository.getAllFollowedSeller(userId);
        List<User> users = followedUsers.stream().map(user_id -> personRepository.findUserById(user_id)).collect(Collectors.toList());
        return users;


    }

}

