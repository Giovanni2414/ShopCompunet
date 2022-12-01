package com.icesi.edu.Shop.api;

import com.icesi.edu.Shop.dto.UserDTO;
import com.icesi.edu.Shop.dto.UserRegisterDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
public interface UserAPI {

    @PostMapping("/createUser")
    UserDTO registerNewUser(@RequestBody UserRegisterDTO userRegisterDTO);

    @GetMapping("/users")
    public List<UserDTO> getUsers();

}
