package com.shopka.infrastracture.user.role;

import java.util.Optional;

import com.shopka.domain.user.role.Role;
import com.shopka.domain.user.role.RoleId;
import com.shopka.domain.user.role.RoleName;
import com.shopka.domain.user.role.repository.RoleRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class JpaRoleRepository implements RoleRepository {

    private final JpaRoleEntityRepository jpaRoleEntityRepository;

    private final RoleMapper roleMapper;

    @Override
    public Optional<Role> findById(RoleId id) {
        return jpaRoleEntityRepository.findById(id.getValue()).map(roleMapper::toRole);
    }

    @Override
    public Optional<Role> findByName(RoleName name) {
        return jpaRoleEntityRepository.findByName(name.getName()).map(roleMapper::toRole);
    }

    @Override
    public void save(Role role) {
        jpaRoleEntityRepository.save(roleMapper.toRoleEntity(role));
    }

}
