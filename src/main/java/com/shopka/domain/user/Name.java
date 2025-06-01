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

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Name other && name.equals(other.name);
    }

}

