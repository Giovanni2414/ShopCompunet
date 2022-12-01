package com.icesi.edu.Shop.service;

import com.icesi.edu.Shop.dto.UserDTO;
import com.icesi.edu.Shop.dto.UserRegisterDTO;
import com.icesi.edu.Shop.model.User;

import java.util.List;

public interface UserService {

    User registerNewUser(User userRegisterDTO);

    public List<User> getUsers();

}
