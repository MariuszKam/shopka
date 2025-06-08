package com.shopka.infrastracture.user;

import com.shopka.domain.user.*;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.instancio.Select.field;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        UserMapperImpl.class,
        RoleMapperImpl.class
})
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void shouldMapEntityToDomainCorrectly() {
        UserEntity userEntity = Instancio.of(UserEntity.class)
                                         .generate(field("email"),
                                                   gen -> gen.text().pattern("user#d#d#d@example.com"))
                                         .create();

        User mapped = userMapper.toUser(userEntity);

        assertNotNull(mapped);
        assertEquals(userEntity.getId(), mapped.getId().getValue());
        assertEquals(userEntity.getEmail(), mapped.getEmail().getValue());
        assertEquals(userEntity.getName(), mapped.getName().getName());
        assertEquals(userEntity.getPassword(), mapped.getPassword().getHash());
        assertEquals(userEntity.getRoles().size(), mapped.getRoles().size());
    }

    @Test
    void shouldMapDomainToEntityCorrectly() {
        User domainUser = Instancio.create(User.class);
        UserEntity mapped = userMapper.toEntity(domainUser);

        assertNotNull(mapped);
        assertEquals(domainUser.getId().getValue(), mapped.getId());
        assertEquals(domainUser.getEmail().getValue(), mapped.getEmail());
        assertEquals(domainUser.getName().getName(), mapped.getName());
        assertEquals(domainUser.getPassword().getHash(), mapped.getPassword());
        assertEquals(domainUser.getRoles().size(), mapped.getRoles().size());
    }
}
