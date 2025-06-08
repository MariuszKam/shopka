package com.shopka.infrastracture.user;

import com.shopka.domain.user.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface UserMapper {

    @Mapping(target = "id.value", source = "id")
    @Mapping(target = "email.value", source = "email")
    @Mapping(target = "name.name", source = "name")
    @Mapping(target = "password.hash", source = "password")
    User toUser(UserEntity entity);

    @InheritInverseConfiguration
    UserEntity toEntity(User user);
}
