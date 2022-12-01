package com.icesi.edu.Shop.service.impl;

import com.icesi.edu.Shop.dto.UserDTO;
import com.icesi.edu.Shop.dto.UserRegisterDTO;
import com.icesi.edu.Shop.model.User;
import com.icesi.edu.Shop.repository.RoleRepository;
import com.icesi.edu.Shop.repository.UserRepository;
import com.icesi.edu.Shop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UUID ID_CLIENT_ROLE = UUID.fromString("09409500-71bb-11ed-a1eb-0242ac120002");
    public final UserRepository userRepository;
    public final RoleRepository roleRepository;

    @Override
    public User registerNewUser(User userRegisterDTO) {
        userRegisterDTO.setRole(roleRepository.findById(ID_CLIENT_ROLE).orElse(null));
        return userRepository.save(userRegisterDTO);
    }

    @Override
    public List<User> getUsers() {
        return StreamSupport.stream(userRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }

}