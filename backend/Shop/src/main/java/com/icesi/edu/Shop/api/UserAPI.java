package com.icesi.edu.Shop.api;

import com.icesi.edu.Shop.dto.UserDTO;
import com.icesi.edu.Shop.dto.UserRegisterDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@CrossOrigin(origins = "*")
public interface UserAPI {

    @PostMapping()
    UserDTO registerNewUser(@RequestBody UserRegisterDTO userRegisterDTO);

    @GetMapping()
    public List<UserDTO> getUsers();

}
