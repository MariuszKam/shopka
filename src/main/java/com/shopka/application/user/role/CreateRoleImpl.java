package com.shopka.application.user.role;

import java.util.Objects;

import com.shopka.domain.user.role.Role;
import com.shopka.domain.user.role.RoleId;
import com.shopka.domain.user.role.RoleName;
import com.shopka.domain.user.role.repository.RoleRepository;
import com.shopka.domain.user.role.usecase.CreateRole;

public class CreateRoleImpl implements CreateRole {

    private final RoleRepository roleRepository;


    public CreateRoleImpl(RoleRepository roleRepository) {
        this.roleRepository = Objects.requireNonNull(roleRepository);
    }


    @Override
    public Role createRole(String name) {
        RoleName createName = new RoleName(name);

        if (roleRepository.findByName(createName).isPresent()) {
            throw new IllegalArgumentException("Role already exists");
        }

        Role role = new Role(RoleId.random(), createName);
        roleRepository.save(role);
        return role;
    }

    
}
