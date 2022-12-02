package com.icesi.edu.Shop.mapper;

import com.icesi.edu.Shop.dto.RoleDTO;
import com.icesi.edu.Shop.model.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDTO fromRole(Role role);
    Role fromRoleDTO(RoleDTO roleDTO);

}
