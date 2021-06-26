package com.conferenceIT.conferenceIT.controller;

import com.conferenceIT.conferenceIT.model.Users;
import com.conferenceIT.conferenceIT.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


   @GetMapping("/all")
    public ResponseEntity<List<Users>> getAllUsers() {
       List<Users> users = userService.findAllUsers();
       return new ResponseEntity<>(users, HttpStatus.OK);

   }

    @GetMapping("/find/{id}")
    public ResponseEntity<Users> getUsersById(@PathVariable("id") Long id ) {
        Users users = userService.findUsersById(id);
        return new ResponseEntity<>(users, HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<Users> addUsers(@RequestBody Users users) {
        Users newUsers = userService.addUser(users);
        return new ResponseEntity<>(newUsers, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Users> updateUsers(@RequestBody Users users) {
        Users updateUsers = userService.addUser(users);
        return new ResponseEntity<>(updateUsers, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUsers(@PathVariable("id") Long id) {
         userService.deleteUser(id);
         return new ResponseEntity<>(HttpStatus.OK);
    }







}
