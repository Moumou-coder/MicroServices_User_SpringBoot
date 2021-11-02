package org.helb.baseproject.service;

import org.helb.baseproject.model.user.User;
import org.helb.baseproject.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //this method return list of users
    public List<User> getUsers (){
        return userRepository.findAll();
    }
}
