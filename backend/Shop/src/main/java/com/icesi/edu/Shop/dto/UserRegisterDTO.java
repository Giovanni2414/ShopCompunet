package com.icesi.edu.Shop.dto;

import com.icesi.edu.Shop.model.Role;
import com.icesi.edu.Shop.validation.CustomAnnotations;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDTO {

    private UUID id;

    @Size(min = 1, max = 255)
    @CustomAnnotations.EmailValidation
    private String email;

    @CustomAnnotations.PasswordValidation
    private String password;

    @NotNull
    @NotBlank
    @Size(min =1, max = 255)
    private String address;

    @CustomAnnotations.PhoneValidation
    private String phoneNumber;

    private RoleDTO rol;

}
