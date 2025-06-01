package com.shopka.application.user;

import java.util.Objects;
import java.util.Set;

import com.shopka.domain.user.Email;
import com.shopka.domain.user.Name;
import com.shopka.domain.user.Password;
import com.shopka.domain.user.PasswordEncoderPort;
import com.shopka.domain.user.User;
import com.shopka.domain.user.UserId;
import com.shopka.domain.user.repository.UserRepository;
import com.shopka.domain.user.role.Role;
import com.shopka.domain.user.role.RoleName;
import com.shopka.domain.user.role.repository.RoleRepository;
import com.shopka.domain.user.usecase.CreateCustomer;

public class CreateCustomerImpl implements CreateCustomer {

    private final UserRepository userRepository;

    private final PasswordEncoderPort passwordEncoderPort;

    private final RoleRepository roleRepository;

    public CreateCustomerImpl(UserRepository userRepository, PasswordEncoderPort passwordEncoderPort,
            RoleRepository roleRepository) {
        this.userRepository = Objects.requireNonNull(userRepository);
        this.passwordEncoderPort = Objects.requireNonNull(passwordEncoderPort);
        this.roleRepository = Objects.requireNonNull(roleRepository);
    }

    @Override
    public User createCustomer(String name, String email, String password) {
        Email customerEmail = new Email(email);

        if (userRepository.findByEmail(customerEmail).isPresent()) {
            throw new IllegalArgumentException("Email already used");
        }

        RoleName roleName = new RoleName("CUSTOMER");

        Role customerRole = roleRepository.findByName(roleName)
                .orElseThrow(() -> new IllegalArgumentException("Role CUSTOMER not found"));

        Name customerName = new Name(name);

        String encodedPassword = passwordEncoderPort.encode(password);

        Password customerPassword = new Password(encodedPassword);

        User customer = new User(UserId.random(), customerEmail, customerName, customerPassword, Set.of(customerRole));

        userRepository.save(customer);

        return customer;

    }

}
