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

}
