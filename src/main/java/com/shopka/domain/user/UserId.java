package com.shopka.domain.user;

import java.util.Objects;
import java.util.UUID;

public class UserId {

    private final UUID value;

    public UserId(UUID value) {
        this.value = Objects.requireNonNull(value);
    }

    public static UserId random() {
        return new UserId(UUID.randomUUID());
    }

    public UUID getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof UserId other && value.equals(other.value);
    }
}
