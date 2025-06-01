package com.shopka.domain.user.role.repository;

import java.util.Optional;

import com.shopka.domain.user.role.Role;
import com.shopka.domain.user.role.RoleId;
import com.shopka.domain.user.role.RoleName;

public interface RoleRepository {

    Optional<Role> findById(RoleId id);

    Optional<Role> findByName(RoleName name);

    void save(Role role);
}
