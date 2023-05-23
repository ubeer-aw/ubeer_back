package fr.ubeer.ubeer_back.controller;

import fr.ubeer.ubeer_back.entity.Brewery;
import fr.ubeer.ubeer_back.entity.Product;
import fr.ubeer.ubeer_back.entity.User;
import fr.ubeer.ubeer_back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping( "/api/private/user" )
    public void createUser(@RequestParam String email) {
        if (userService.findUserByEmail(email) == null) {
            User user = new User();
            user.setEmail(email);
            userService.addUser(user);
        }
    }
}
