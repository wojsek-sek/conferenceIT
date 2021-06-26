package com.conferenceIT.conferenceIT.service;

import com.conferenceIT.conferenceIT.model.Users;
import com.conferenceIT.conferenceIT.registration.EmailValidator;
import com.conferenceIT.conferenceIT.registration.RegistrationRequest;
import com.conferenceIT.conferenceIT.registration.UserRole;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final EmailValidator emailValidator;

    private final UserService userService;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.
                test(request.getEmail());

        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }

        return userService.signUpUser(
                new Users(
                        request.getUsername(),
                        request.getPassword(),
                        request.getEmail(),
                        UserRole.USER
                )
        );
    }

}
