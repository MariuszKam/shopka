package com.shopka.domain.user.repository;

import java.util.Optional;

import com.shopka.domain.user.Email;
import com.shopka.domain.user.User;
import com.shopka.domain.user.UserId;

public interface UserRepository {

    Optional<User> findById(UserId id);

    Optional<User> findByEmail(Email email);

    void save(User user);
}
