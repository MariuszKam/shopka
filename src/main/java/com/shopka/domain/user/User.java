package com.shopka.domain.user;

import java.util.Objects;
import java.util.Set;

import com.shopka.domain.user.role.Role;

public class User {

    private final UserId id;

    private final Email email;

    private final Name name;

    private final Password password;

    private final Set<Role> roles;

    public User(UserId id, Email email, Name name, Password password, Set<Role> roles) {
        this.id = Objects.requireNonNull(id);
        this.email = Objects.requireNonNull(email);
        this.name = Objects.requireNonNull(name);
        this.password = Objects.requireNonNull(password);
        this.roles = Objects.requireNonNull(roles);
    }

    public UserId getId() {
        return id;
    }

    public Email getEmail() {
        return email;
    }

    public Name getName() {
        return name;
    }

    public Password getPassword() {
        return password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof User other && id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
