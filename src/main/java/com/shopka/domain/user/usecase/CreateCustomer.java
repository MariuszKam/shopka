package com.shopka.domain.user.usecase;

import com.shopka.domain.user.User;

public interface CreateCustomer {
    User createCustomer(String name, String email, String password);
}
