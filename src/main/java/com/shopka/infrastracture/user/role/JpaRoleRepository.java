package com.shopka.infrastracture.user.role;

import java.util.Optional;

import com.shopka.domain.user.role.Role;
import com.shopka.domain.user.role.RoleId;
import com.shopka.domain.user.role.RoleName;
import com.shopka.domain.user.role.repository.RoleRepository;

import org.springframework.stereotype.Repository;

@Repository
public class JpaRoleRepository implements RoleRepository {

    @Override
    public Optional<Role> findById(RoleId id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public Optional<Role> findByName(RoleName name) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public void save(Role role) {
        // TODO Auto-generated method stub
        
    }

    
}
