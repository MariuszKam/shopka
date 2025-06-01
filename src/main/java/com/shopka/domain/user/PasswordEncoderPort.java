package com.shopka.domain.user;

public interface PasswordEncoderPort {

    String encode(String password);
    boolean matches(String rawPassword, String hash);
}
