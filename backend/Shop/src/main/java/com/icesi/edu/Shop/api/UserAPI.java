package com.icesi.edu.Shop.api;

import com.icesi.edu.Shop.dto.UserDTO;
import com.icesi.edu.Shop.dto.UserRegisterDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/users")
@CrossOrigin(origins = "*")
public interface UserAPI {

    @PostMapping()
    public UserDTO registerNewUser(@RequestBody UserRegisterDTO userRegisterDTO);

    @GetMapping()
    public List<UserDTO> getUsers();

    @GetMapping("/{userId}")
    public UserDTO getUser(@PathVariable UUID userId);

    @PostMapping("/becomeAdmin/{userId}")
    public UserDTO becomeAdmin(@PathVariable UUID userId);

    @GetMapping("/personalInfo")
    public UserDTO getPersonalInfoOfLoggedUser();

}
