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

    @Override
    public int hashCode() {
        return hash.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Password other && hash.equals(other.hash);
    }

    @Override
    public String toString() {
        return "Password hash";
    }
}
