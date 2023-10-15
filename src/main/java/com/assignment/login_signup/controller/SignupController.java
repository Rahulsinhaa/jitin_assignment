package com.assignment.login_signup.controller;

import com.assignment.login_signup.model.User;
import com.assignment.login_signup.services.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signup")
public class SignupController {
    @Autowired
    private  SignupService signupService;



    @PostMapping
    public User signup(@RequestBody User signupRequest) {
        // Extract user data from the request
        String username = signupRequest.getUsername();
        String email = signupRequest.getEmail();
        String password = signupRequest.getPassword();

        // Create a User object
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        // Call the signup service to register the user
        return signupService.registerUser(user);
    }



    @PutMapping("/{username}/update-password")
    public User updatePassword(@PathVariable String username, @RequestParam String newPassword) {
        // Call the signup service to update the user's password
        return signupService.updatePassword(username, newPassword);
    }
}
