package com.shopka.domain.user.role;

import java.util.Objects;

public class Role {

    private final RoleId id;

    private final RoleName name;

    public Role(RoleId id, RoleName name) {
        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
    }

    public RoleId getId() {
        return id;
    }

    public RoleName getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Role other && id.equals(other.id);
    }
}
