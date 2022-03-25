package com.quinbay.ecommerce.user_microservice.service;

import com.quinbay.ecommerce.user_microservice.dto.User;
import com.quinbay.ecommerce.user_microservice.entity.UserEntity;
import com.quinbay.ecommerce.user_microservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(User user){

        Optional<UserEntity> optionalUserEntity = userRepository.findByEmail(user.getEmail());

        if(optionalUserEntity.isPresent()){
            return;
        }
        else {
            UserEntity userEntity = new UserEntity(user.getId(), user.getEmail(), user.getName(), user.getPassword());
             userRepository.save(userEntity);
        }


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



    @Override
    public User getUserByEmailandPassword(String emailId,String password){

        Optional<UserEntity> optionalUserEntity = userRepository.findByEmailAndPassword(emailId,password);



        if(optionalUserEntity.isPresent()){
            User user = new User(optionalUserEntity.get().getId(),optionalUserEntity.get().getEmail(),optionalUserEntity.get().getName(),optionalUserEntity.get().getPassword());
            return user;

        }
        else {
            throw new RuntimeException("Not Found");
        }



    }


}
