package com.icesi.edu.Shop.controller;

import com.icesi.edu.Shop.api.LoginAPI;
import com.icesi.edu.Shop.dto.LoginDTO;
import com.icesi.edu.Shop.dto.TokenDTO;
import com.icesi.edu.Shop.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*")
public class LoginController implements LoginAPI {


    private final LoginService loginService;

    @Override
    public TokenDTO login(LoginDTO loginDTO) {
        return loginService.login(loginDTO);
    }
}
