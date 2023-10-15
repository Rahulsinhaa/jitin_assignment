package com.assignment.login_signup.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(value = "user") // Assuming you want to store user information
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id // This annotation marks the field as the primary key
    private String id;
    private String username;
    private String email;
    private String password;

    // Constructors, getters, and setters can be added here
}
