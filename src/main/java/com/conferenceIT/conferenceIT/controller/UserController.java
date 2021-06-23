package com.conferenceIT.conferenceIT.controller;

import com.conferenceIT.conferenceIT.model.Users;
import com.conferenceIT.conferenceIT.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/users")
    public List<Users> getUsers() {
        return userService.getUsers();

    }

    @GetMapping("/users/{id}")
    public Users getOneUser(@PathVariable long id ) {
        return userService.getOneUser(id);
    }



}
