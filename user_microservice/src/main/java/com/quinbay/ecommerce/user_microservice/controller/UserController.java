package com.quinbay.ecommerce.user_microservice.controller;

import com.quinbay.ecommerce.user_microservice.dto.User;
import com.quinbay.ecommerce.user_microservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController

public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/addUser" , consumes = "application/json")
    public void addUser(@RequestBody @Valid User user){

        userService.addUser(user);
    }

    @GetMapping(value = "/user" , produces = "application/json")
    public List<User> getStudents(){

        return userService.getAllUsers();
    }

    @GetMapping(value = "/authenticate",produces = "application/json")
    public User authenticate(@RequestParam String email,@RequestParam String password){
        return userService.getUserByEmailandPassword(email,password);
    }


}
