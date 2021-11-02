package org.helb.baseproject.model.user;

import org.helb.baseproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user/")
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

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }

    @PutMapping(path = "{userId}")
    public void updateUser(@PathVariable("userId") Long userId,
                           @RequestParam(required = false) String lastName,
                           @RequestParam(required = false) String firstName,
                           @RequestParam(required = false) String pseudo,
                           @RequestParam(required = false) String mail)
    {
        userService.updateUser(userId, lastName, firstName, pseudo, mail);
    }
}
