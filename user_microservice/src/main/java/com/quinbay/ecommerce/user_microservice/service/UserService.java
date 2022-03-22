package com.quinbay.ecommerce.user_microservice.service;

import com.quinbay.ecommerce.user_microservice.dto.User;

import java.util.List;

public interface UserService {

    void addUser(User user);
    List<User>getAllUsers();

}
