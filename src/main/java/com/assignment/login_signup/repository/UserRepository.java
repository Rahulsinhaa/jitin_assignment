package com.assignment.login_signup.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.assignment.login_signup.model.User;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
    User findByEmail(String email);
}