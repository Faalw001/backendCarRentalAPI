package com.fatina.wckunder.controller;

import com.fatina.wckunder.model.User;
import com.fatina.wckunder.repo.UserRepository;
import com.fatina.wckunder.repo.UserServiceRepository;
import com.fatina.wckunder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;


    @GetMapping(value="/customers")
    public List<User> getAllUsers(){return userService.getAllUsers();}

    //not in project just for prop data
    @PostMapping(value="/saveuser")
    public ResponseEntity <User>saveUser(@RequestBody User user) {
        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
    }
}
