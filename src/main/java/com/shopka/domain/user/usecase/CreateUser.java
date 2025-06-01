package com.shopka.domain.user.usecase;

import com.shopka.domain.user.User;

public interface CreateUser {
    User createUser(String name, String email, String password);
}
