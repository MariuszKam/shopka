package com.shopka.application.user;

import com.shopka.domain.user.Email;
import com.shopka.domain.user.Name;
import com.shopka.domain.user.Password;
import com.shopka.domain.user.PasswordEncoderPort;
import com.shopka.domain.user.User;
import com.shopka.domain.user.repository.UserRepository;
import com.shopka.domain.user.usecase.CreateUser;

public class CreateUserImpl implements CreateUser {

    private final UserRepository userRepository;

    private final PasswordEncoderPort passwordEncoderPort;

    public CreateUserImpl(UserRepository userRepository, PasswordEncoderPort passwordEncoderPort) {
        this.userRepository = userRepository;
        this.passwordEncoderPort = passwordEncoderPort;
    }

    @Override
    public User createUser(String name, String email, String password) {
        Email userEmail = new Email(email);

        if (userRepository.findByEmail(userEmail).isPresent()) {
            throw new IllegalArgumentException("Email already used");
        }

        Name userName = new Name(name);

        String encodedPassword = passwordEncoderPort.encode(password);

        Password userPassword = new Password(encodedPassword);

    }

}
