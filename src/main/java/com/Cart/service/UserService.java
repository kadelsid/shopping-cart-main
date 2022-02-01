package com.Cart.service;

import com.Cart.dto.UserRequest;
import com.Cart.model.User;
import com.Cart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserRequest userRequest) {
        User newUser = new User();
        newUser.setEmail(userRequest.getEmail());
        newUser.setFirstName(userRequest.getFirstName());
        newUser.setLastName(userRequest.getLastName());
        newUser.setPassword(encodePassword(userRequest.getPassword()));
        return userRepository.save(newUser);
    }

    private String encodePassword (String password){
        return passwordEncoder.encode(password);

    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {

        return userRepository.findById(id);
    }

    public User updateUser(User user, UserRequest userRequest){
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        return userRepository.save(user);
    }

    public void deleteUser(Long id){
         userRepository.deleteById(id);
    }

    public Optional<User> getUserByEmail(String email){
        return userRepository.findByEmail(email);

    }

   public Optional<User> getUserByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    public Optional<User> getUserByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }
}
