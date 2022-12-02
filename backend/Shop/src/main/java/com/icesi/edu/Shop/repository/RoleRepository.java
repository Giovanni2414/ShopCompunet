package com.icesi.edu.Shop.repository;

import com.icesi.edu.Shop.model.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends CrudRepository<Role, UUID> {

    Role findRoleByName(String role_name);

}
