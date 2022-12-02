package com.icesi.edu.Shop.dto;

import com.icesi.edu.Shop.model.Permission;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleDTO {

    private UUID roleId;

    private String name;

    private String description;

    private List<Permission> rolePermissions;

}
