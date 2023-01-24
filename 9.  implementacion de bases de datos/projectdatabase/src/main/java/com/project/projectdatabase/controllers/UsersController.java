package com.project.projectdatabase.controllers;


import com.project.projectdatabase.entity.Users;
import com.project.projectdatabase.services.IUsersService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {

    @Autowired
    private IUsersService iUsersService;

    private Users users;

    @PostMapping("/createNewUser")
    public ResponseEntity createNewUser(@RequestBody Users users){
        users = iUsersService.createNewUser(users);
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @GetMapping("/listUsers")
    public List<Users> findAllUsers(){
        List<Users> listUsers = iUsersService.findAllUsers();
        return listUsers;
    }

    @GetMapping("/findUserById/{id}")
    public ResponseEntity findUserById(@PathVariable Integer id){
        users = iUsersService.findUsersById(id);
        return new ResponseEntity(users, HttpStatus.OK);
    }


    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Integer id){
        iUsersService.deleteUserById(id);
    }
}
