package com.icesi.edu.Shop.dto;

import com.icesi.edu.Shop.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private UUID id;

    private String email;

    private String address;

    private String phoneNumber;

    private Role rol;

}