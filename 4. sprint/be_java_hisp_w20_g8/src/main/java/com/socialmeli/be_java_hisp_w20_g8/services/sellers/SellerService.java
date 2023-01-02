package com.socialmeli.be_java_hisp_w20_g8.services.sellers;

import com.socialmeli.be_java_hisp_w20_g8.dto.UserCountDTO;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.NotFoundException;
import com.socialmeli.be_java_hisp_w20_g8.models.Seller;
import com.socialmeli.be_java_hisp_w20_g8.repositories.persons.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService implements ISellerService{

    @Autowired
    PersonRepository personRepository;


    public UserCountDTO followersCount(int userId){
        Seller seller = personRepository.getById(userId);
        if (seller == null){throw new NotFoundException("User not found:: "+userId);}

        UserCountDTO userCountDTO = new UserCountDTO(userId,seller.getUser_name(),((Seller) seller).getFollowers().size());
        return userCountDTO;

    }

}

