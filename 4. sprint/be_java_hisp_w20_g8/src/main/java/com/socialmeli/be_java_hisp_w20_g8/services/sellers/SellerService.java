package com.socialmeli.be_java_hisp_w20_g8.services.sellers;

import com.socialmeli.be_java_hisp_w20_g8.dto.SellerFollowersDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.UserDTO;
import com.socialmeli.be_java_hisp_w20_g8.exceptions.NotFoundException;
import com.socialmeli.be_java_hisp_w20_g8.models.Seller;
import com.socialmeli.be_java_hisp_w20_g8.repositories.persons.IPersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.socialmeli.be_java_hisp_w20_g8.dto.UserCountDTO;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class SellerService implements ISellerService{

    @Autowired
    IPersonRepository IPersonRepository;


    public UserCountDTO followersCount(int userId){
        Seller seller = IPersonRepository.getById(userId);
        if (seller == null){throw new NotFoundException("User not found: "+userId);}

        UserCountDTO userCountDTO = new UserCountDTO(userId,seller.getUser_name(),((Seller) seller).getFollowers().size());
        return userCountDTO;

    }

    ModelMapper modelMapper= new ModelMapper();


    @Override
    public SellerFollowersDTO getSellerFollowers(Integer userId, String order) {

        Seller seller = IPersonRepository.findSellerById(userId);

        if(seller!=null) {

             SellerFollowersDTO sellerFollowersDTO = new SellerFollowersDTO(seller.getId(),seller.getUser_name(),
                    seller.getFollowers().stream().map(id -> IPersonRepository.findUserById(id)).collect(Collectors.toList())
                            .stream().map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList()));

             String orderType = order != null ? order : "";

             switch (orderType) {
                 case "name_asc":
                     sellerFollowersDTO.setFollowers(sellerFollowersDTO.getFollowers().stream().sorted(Comparator.comparing(UserDTO::getUser_name)).collect(Collectors.toList()));
                     break;
                 case "name_desc":
                     sellerFollowersDTO.setFollowers(sellerFollowersDTO.getFollowers().stream().sorted((a,b) -> b.getUser_name().compareTo(a.getUser_name())).collect(Collectors.toList()));
                     break;
             }

            return sellerFollowersDTO;

        }else{

            throw new NotFoundException("User with id: " + userId + " not found");
        }


    }
}
