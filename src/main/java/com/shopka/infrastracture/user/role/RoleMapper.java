package com.shopka.infrastracture.user.role;

import com.shopka.domain.user.role.Role;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    
    @Mapping(target = "id.value", source = "id")
    @Mapping(target = "name.name", source = "name")
    Role toRole(RoleEntity entity);

    @InheritInverseConfiguration
    RoleEntity toRoleEntity(Role role);

}
