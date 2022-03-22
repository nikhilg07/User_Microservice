package com.quinbay.ecommerce.user_microservice.repository;

import com.quinbay.ecommerce.user_microservice.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> {
}

