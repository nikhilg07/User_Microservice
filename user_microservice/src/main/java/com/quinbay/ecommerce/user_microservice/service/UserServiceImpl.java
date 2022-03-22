package com.quinbay.ecommerce.user_microservice.service;

import com.quinbay.ecommerce.user_microservice.dto.User;
import com.quinbay.ecommerce.user_microservice.entity.UserEntity;
import com.quinbay.ecommerce.user_microservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(User user){
        UserEntity userEntity = new UserEntity(user.getId(),user.getEmail(),user.getName(),user.getPassword());
        userRepository.save(userEntity);
    }

    @Override
    public List<User> getAllUsers() {
        Iterable<UserEntity> userEntityList = userRepository.findAll();
        List<User> userResponseList = new ArrayList<>();

        for (UserEntity userEntity : userEntityList) {
            User user = new User(userEntity.getId(),userEntity.getEmail(),userEntity.getName(),userEntity.getPassword());
            userResponseList.add(user);
        }
        return userResponseList;
    }


}
