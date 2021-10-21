package org.helb.baseproject.service;

import org.helb.baseproject.model.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public List<User> getUsers (){
        return List.of(
                new User(
                        1L,
                        "Moumou",
                        "Batmou",
                        "DiamondBlack",
                        "mail@hotmail.com",
                        "TestPass"
                )
        );
    }
}
