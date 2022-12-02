package com.icesi.edu.Shop.service.impl;

import com.icesi.edu.Shop.dto.LoginDTO;
import com.icesi.edu.Shop.dto.TokenDTO;
import com.icesi.edu.Shop.model.User;
import com.icesi.edu.Shop.repository.UserRepository;
import com.icesi.edu.Shop.service.LoginService;
import com.icesi.edu.Shop.utils.JWTParser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {

    public final UserRepository userRepository;

    @Override
    public TokenDTO login(LoginDTO loginDTO) {

        User user = StreamSupport.stream(userRepository.findAll().spliterator(),false)
                .filter(user1 -> user1.getEmail().equals(loginDTO.getEmail()))
                .findFirst()
                .orElseThrow();
        if(user.getPassword().equals(loginDTO.getPassword())) {
            Map<String, String> claims = new HashMap<>();
            claims.put("userId", user.getId().toString());
            return new TokenDTO(JWTParser.createJWT(user.getId().toString(),user.getEmail(), user.getPassword(), claims,1000000000L));
        }
        throw new InvalidParameterException();

    }

}
