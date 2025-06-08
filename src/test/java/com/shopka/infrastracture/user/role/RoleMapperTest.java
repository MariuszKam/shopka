package com.shopka.infrastracture.user.role;

import com.shopka.domain.user.role.Role;
import com.shopka.infrastracture.user.RoleEntity;
import com.shopka.infrastracture.user.RoleMapper;
import com.shopka.infrastracture.user.RoleMapperImpl;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = RoleMapperImpl.class)
public class RoleMapperTest {

    @Autowired
    private RoleMapper mapper;

    @Test
    void shouldMapEntityToDomainCorrectly() {
       RoleEntity entity = Instancio.create(RoleEntity.class);

        Role role = mapper.toRole(entity);

        assertNotNull(role);
        assertEquals(entity.getId(), role.getId().getValue());
        assertEquals(entity.getName(), role.getName().getName());
    }

    @Test
    void shouldMapDomainToEntityCorrectly() {
        Role roleDomain = Instancio.create(Role.class);

        RoleEntity entity = mapper.toRoleEntity(roleDomain);

        assertNotNull(entity);
        assertEquals(roleDomain.getId().getValue(), entity.getId());
        assertEquals(roleDomain.getName().getName(), entity.getName());
    }
}
