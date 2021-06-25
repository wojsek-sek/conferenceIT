package com.conferenceIT.conferenceIT.service;


import com.conferenceIT.conferenceIT.exception.UserNotFoundException;
import com.conferenceIT.conferenceIT.model.Users;
import com.conferenceIT.conferenceIT.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public Users addUser(Users user) {
        user.setUserCode(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    public Users updateUser(Users user){
        return userRepository.save(user);
    }

    public void deleteUser(Long id ){
        userRepository.deleteUsersById(id);
    }

    public List<Users> findAllUsers() {
        return userRepository.findAll();
    }

    public Users findUsersById(Long id) {
        return userRepository.findUsersById(id).orElseThrow(()->new UserNotFoundException("User not found"));

    }
}
