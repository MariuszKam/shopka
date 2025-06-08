package com.shopka;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import com.shopka.domain.user.role.Role;
import com.shopka.domain.user.role.RoleId;
import com.shopka.domain.user.role.RoleName;
import com.shopka.infrastracture.user.role.RoleEntity;
import com.shopka.infrastracture.user.role.RoleMapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RoleMapperTest {

    @Autowired
    private RoleMapper mapper;

    @Test
    void shouldMapEntityToDomainCorrectly() {
        UUID uuid = UUID.randomUUID();
        RoleEntity entity = new RoleEntity();
        entity.setId(uuid);
        entity.setName("ADMIN");

        Role role = mapper.toRole(entity);

        assertNotNull(role);
        assertEquals(uuid, role.getId().getValue());
        assertEquals("ADMIN", role.getName().getName());
    }

    @Test
    void shouldMapDomainToEntityCorrectly() {
        UUID uuid = UUID.randomUUID();
        RoleId roleId = new RoleId(uuid);
        RoleName name = new RoleName("USER");

        Role role = new Role(roleId, name);

        RoleEntity entity = mapper.toRoleEntity(role);

        assertNotNull(entity);
        assertEquals(uuid, entity.getId());
        assertEquals("USER", entity.getName());
    }
}
