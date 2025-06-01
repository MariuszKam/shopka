package com.shopka.domain.user;

import java.util.Objects;

public class Password {

    private final String hash;

    public Password(String hash) {
        this.hash = Objects.requireNonNull(hash);
    }

    public String getHash() {
        return hash;
    }

    public boolean matches(String rawPassword, PasswordEncoderPort encoder) {
        return encoder.matches(rawPassword, hash);
    }
}
