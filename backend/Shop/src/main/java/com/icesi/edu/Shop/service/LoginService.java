package com.icesi.edu.Shop.service;

import com.icesi.edu.Shop.dto.LoginDTO;
import com.icesi.edu.Shop.dto.TokenDTO;

public interface LoginService {

    TokenDTO login(LoginDTO loginDTO);

}
