package com.icesi.edu.Shop.controller;

import com.icesi.edu.Shop.api.LoginAPI;
import com.icesi.edu.Shop.dto.LoginDTO;
import com.icesi.edu.Shop.dto.TokenDTO;
import com.icesi.edu.Shop.dto.UserDTO;
import com.icesi.edu.Shop.dto.UserRegisterDTO;
import com.icesi.edu.Shop.mapper.UserMapper;
import com.icesi.edu.Shop.service.LoginService;
import com.icesi.edu.Shop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class LoginController implements LoginAPI {


    private final LoginService loginService;
    public final UserService userService;
    public final UserMapper userMapper;

    @Override
    public TokenDTO login(LoginDTO loginDTO) {
        return loginService.login(loginDTO);
    }

}
