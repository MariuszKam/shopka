package com.shopka.infrastracture.user.role;

import com.shopka.domain.user.role.Role;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    
    @Mapping(target = "id.value", source = "entity.id")
    @Mapping(target = "name.name", source = "entity.name")
    Role toRole(RoleEntity entity);

    @Mapping(target = "id", source = "id.value")
    @Mapping(target = "name", source = "name.name")
    RoleEntity toRoleEntity(Role role);

}
