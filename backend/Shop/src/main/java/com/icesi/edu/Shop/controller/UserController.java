package com.icesi.edu.Shop.controller;

import com.icesi.edu.Shop.api.UserAPI;
import com.icesi.edu.Shop.dto.UserDTO;
import com.icesi.edu.Shop.dto.UserRegisterDTO;
import com.icesi.edu.Shop.mapper.UserMapper;
import com.icesi.edu.Shop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
public class UserController implements UserAPI {

    public final UserService userService;
    public final UserMapper userMapper;

    @Override
    public UserDTO registerNewUser(@RequestBody UserRegisterDTO userRegisterDTO) {
        return userMapper.fromUserToUserDTO(userService
                .registerNewUser(userMapper.fromUserRegisterDTOToUser(userRegisterDTO)));
    }

    @Override
    public List<UserDTO> getUsers() {
        List<UserDTO> users = userService.getUsers().stream().map(userMapper::fromUserToUserDTO).collect(Collectors.toList());
        return users;
    }

    @Override
    public UserDTO getUser(UUID userId) {
        return userMapper.fromUserToUserDTO(userService.getUser(userId));
    }

}
