package com.shopka.domain.user.role;

import java.util.Objects;

public class RoleName {

    private final String name;

    public RoleName(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof RoleName other && name.equals(other.name);
    }

}
