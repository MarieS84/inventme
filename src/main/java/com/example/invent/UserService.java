package com.example.invent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    userRepository userRepository;

    public User addUserToRepository(User u){
    userRepository.save(u);
    return u;
    }

    public List<User> getAllUsers() {
        List<User> users = (List<User>)userRepository.findAll();
        return users;
    }

}
