package org.helb.baseproject.model.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/user/0.1")
public class UserController {

    @GetMapping
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
