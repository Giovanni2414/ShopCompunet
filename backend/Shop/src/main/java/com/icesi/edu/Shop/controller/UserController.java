package com.icesi.edu.Shop.controller;

import com.icesi.edu.Shop.api.UserAPI;
import com.icesi.edu.Shop.dto.UserDTO;
import com.icesi.edu.Shop.dto.UserRegisterDTO;
import com.icesi.edu.Shop.error.exception.ShopError;
import com.icesi.edu.Shop.error.exception.ShopException;
import com.icesi.edu.Shop.mapper.UserMapper;
import com.icesi.edu.Shop.security.SecurityContextHolder;
import com.icesi.edu.Shop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.icesi.edu.Shop.constants.ErrorCodes.CODE_UD_03;

@AllArgsConstructor
@RestController
public class UserController implements UserAPI {

    public final UserService userService;
    public final UserMapper userMapper;

    private void validatePhoneOrEmailPresent(UserRegisterDTO userRegisterDTO) {
        if((userRegisterDTO.getEmail() == null) && (userRegisterDTO.getPhoneNumber() == null)) {
            throw new ShopException(HttpStatus.BAD_REQUEST, new ShopError(CODE_UD_03, CODE_UD_03.getMessage()));
        }
    }

    @Override
    public UserDTO registerNewUser(@RequestBody UserRegisterDTO userRegisterDTO) {
        validatePhoneOrEmailPresent(userRegisterDTO);
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

    @Override
    public UserDTO becomeAdmin(UUID userId) {
        return userMapper.fromUserToUserDTO(userService.becomeAdmin(userId));
    }

    @Override
    public UserDTO getPersonalInfoOfLoggedUser() {
        return userMapper.fromUserToUserDTO(userService.getUser(SecurityContextHolder.getContext().getUserId()));
    }

}
