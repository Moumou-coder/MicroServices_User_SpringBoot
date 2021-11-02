package org.helb.baseproject.model.user;

import org.helb.baseproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user/0.1")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers (){
        return userService.getUsers();
    }

    @PostMapping
    public void registerNewUser (@RequestBody User user){
        userService.addNewUser(user);
    }
}
