package com.icesi.edu.Shop.service;

import com.icesi.edu.Shop.dto.UserDTO;
import com.icesi.edu.Shop.dto.UserRegisterDTO;
import com.icesi.edu.Shop.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    User registerNewUser(User userRegisterDTO);

    public List<User> getUsers();

    public User getUser(UUID userId);

    public User becomeAdmin(UUID userId);

}
