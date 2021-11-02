package org.helb.baseproject.service;

import org.helb.baseproject.model.user.User;
import org.helb.baseproject.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

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

    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.findUserByMail(user.getMail());
        if (userOptional.isPresent()){
            throw new IllegalStateException("email already exists");
        }
        userRepository.save(user);
    }
}
