package com.shopka.domain.user.role;

import java.util.Objects;
import java.util.UUID;

public class RoleId {

    private final UUID value;

    public RoleId(UUID value) {
        this.value = Objects.requireNonNull(value);
    }

    public static RoleId random() {
        return new RoleId(UUID.randomUUID());
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
        return obj instanceof RoleId other && value.equals(other.value);
    }
}

