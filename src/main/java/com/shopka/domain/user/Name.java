package com.shopka.domain.user;

import java.util.Objects;

public class Name {

    private final String name;

    public Name(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public String getName() {
        return name;
    }

}

