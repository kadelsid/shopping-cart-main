package com.technova.shopping_cart.TechNova.Cart.controller;

import com.technova.shopping_cart.TechNova.Cart.Utils.ApiResponse;
import com.technova.shopping_cart.TechNova.Cart.dto.UserRequest;
import com.technova.shopping_cart.TechNova.Cart.model.User;
import com.technova.shopping_cart.TechNova.Cart.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }



    @PostMapping("/users")
    public User createUser(@RequestBody UserRequest userRequest) {
        User savedUser = userService.createUser(userRequest);
        return savedUser;
    }



    @PutMapping ("/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest) {

        Optional<User> existingUser = userService.getUserById(id);
        if(!existingUser.isPresent()){
        }
        return userService.updateUser(existingUser.get(), userRequest);
    }



    @GetMapping("/users")
    public ResponseEntity<Object> getUser(@RequestParam(name = "email", required = false) String email) {

        if (email != null) {
            Optional<User> user = userService.getUserByEmail(email);
            if (user.isPresent()) {
                return ApiResponse.generateResponse(HttpStatus.OK.value(),  "User with email: " + email + "fetched successfully", user, null);
            }
            return ApiResponse.generateResponse(HttpStatus.OK.value(), "User wit email " + email + " not available in the database", null, "User not Found");
        } else {
            List<User> users = userService.getAllUsers();
            if (users.size() > 0) {
                return ApiResponse.generateResponse(HttpStatus.OK.value(), users.size() + " users available", users, null);
            }
            return ApiResponse.generateResponse(HttpStatus.OK.value(), users.size() + "User not available in the database", null, "User not Found");
        }
    }
   // @GetMapping("/users/{id}")
   /* public User getUserById(@PathVariable Long id){
        return userService.getUserById(id).get();

    }*/

/*
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id){
        Optional<User> existingUser = userService.getUserById(id);
        if(!existingUser.isPresent()){

        }
        userService.deleteUser(id);
    }*/



    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Long id){
        Optional<User> existingUser = userService.getUserById(id);
        if(existingUser.isPresent()){
            return ApiResponse.generateResponse(HttpStatus.OK.value(), "User fetched successfully.", existingUser, null);
        }
        return ApiResponse.generateResponse(HttpStatus.NOT_FOUND.value(), "User with id "+ id + " not found in the database.", null, null);
    }


    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id){
        Optional<User> existingUser = userService.getUserById(id);
        if(existingUser.isPresent()){
            return ApiResponse.generateResponse(HttpStatus.OK.value(), "User deleted successfully.", null, null);
        }
        return ApiResponse.generateResponse(HttpStatus.NOT_FOUND.value(), "User with id "+ id + " not found in the database.", null, "User not found.");
    }
}
