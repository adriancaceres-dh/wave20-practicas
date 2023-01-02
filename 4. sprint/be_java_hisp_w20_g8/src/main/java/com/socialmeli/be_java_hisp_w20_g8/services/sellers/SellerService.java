package com.socialmeli.be_java_hisp_w20_g8.services.sellers;

import com.socialmeli.be_java_hisp_w20_g8.dto.SellerDTO;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.OperationFailedException;
import com.socialmeli.be_java_hisp_w20_g8.models.Person;
import com.socialmeli.be_java_hisp_w20_g8.models.Seller;
import com.socialmeli.be_java_hisp_w20_g8.repositories.persons.PersonRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SellerService {

    @Autowired
    private PersonRepositoryImp personRepositoryImp;

    public String searhSeller(Integer sellerId){
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



}
