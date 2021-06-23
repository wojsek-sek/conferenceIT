package com.conferenceIT.conferenceIT.service;


import com.conferenceIT.conferenceIT.model.Users;
import com.conferenceIT.conferenceIT.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;



    public List<Users> getUsers() {
        return userRepository.findAll();

    }


    public Users getOneUser(long id) {
        return userRepository.findById(id)
                .orElseThrow();
    }
}
