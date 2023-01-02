package com.socialmeli.be_java_hisp_w20_g8.services.sellers;

import com.socialmeli.be_java_hisp_w20_g8.repositories.persons.PersonRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SellerService implements ISellerService {
    @Autowired
    PersonRepositoryImp personRepository;

    @Override
    public Map getSellerFollowers(Integer userId) {

        if(personRepository.checkUser(userId)){

             personRepository.
        };
        return null;
    }
}
