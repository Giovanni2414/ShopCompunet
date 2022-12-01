package com.icesi.edu.Shop.api;

import com.icesi.edu.Shop.dto.LoginDTO;
import com.icesi.edu.Shop.dto.TokenDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/login")
@CrossOrigin(origins = "*")
public interface LoginAPI {

    @PostMapping
    TokenDTO login(@RequestBody LoginDTO loginDTO);

}