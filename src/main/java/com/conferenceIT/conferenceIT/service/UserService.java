package com.conferenceIT.conferenceIT.service;


import com.conferenceIT.conferenceIT.exception.UserNotFoundException;
import com.conferenceIT.conferenceIT.model.Users;
import com.conferenceIT.conferenceIT.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;





    private final static String USER_NOT_FOUND_MESSAGE = "non user with mail %s";

    public Users addUser(Users user) {
        user.setUserCode(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    public Users updateUser(Users user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteUsersById(id);
    }

    public List<Users> findAllUsers() {
        return userRepository.findAll();
    }

    public Users findUsersById(Long id) {
        return userRepository.findUsersById(id).orElseThrow(() -> new UserNotFoundException("User not found"));

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException(String.format(USER_NOT_FOUND_MESSAGE, email)));
    }



    public String signUpUser(Users users) {
        boolean userExists = userRepository
                .findByEmail(users.getEmail())
                .isPresent();

        if (userExists) {

            throw new IllegalStateException("email already taken");
        }


        userRepository.save(users);

        return "sss";
    }
}