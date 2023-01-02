package com.socialmeli.be_java_hisp_w20_g8.services.sellers;

import com.socialmeli.be_java_hisp_w20_g8.dto.SellerDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.UserDTO;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.NotFoundException;
import com.socialmeli.be_java_hisp_w20_g8.models.Seller;
import com.socialmeli.be_java_hisp_w20_g8.models.User;
import com.socialmeli.be_java_hisp_w20_g8.repositories.persons.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SellerService implements ISellerService {
    ModelMapper modelMapper= new ModelMapper();
    @Autowired
    PersonRepository personRepository;

    @Override
    public Map<SellerDTO, List<UserDTO>> getSellerFollowers(Integer userId) {

        Map<SellerDTO, List<UserDTO>> listaResponse = new HashMap<>();

        Seller seller = personRepository.findSellerById(userId);

        if(seller!=null) {

            List<User> listaFollowers = seller.getFollowers().stream().map(UserID -> personRepository.findUserById(userId)).collect(Collectors.toList());
            List<UserDTO> listaFollowersDTO = listaFollowers.stream().map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
            SellerDTO sellerDTO = modelMapper.map(seller,SellerDTO.class);
            listaResponse.put(sellerDTO,listaFollowersDTO);

            return listaResponse;

        }else{

            throw new NotFoundException("User with id: + " + userId + "not found");
        }


    }
}
