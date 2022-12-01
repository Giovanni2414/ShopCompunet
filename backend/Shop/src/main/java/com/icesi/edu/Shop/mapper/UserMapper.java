package com.icesi.edu.Shop.mapper;

import com.icesi.edu.Shop.dto.UserDTO;
import com.icesi.edu.Shop.dto.UserRegisterDTO;
import com.icesi.edu.Shop.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User fromUserDTOToUser(UserDTO userDTO);
    UserDTO fromUserRegisterDTOToUserDTO(UserRegisterDTO userRegisterDTO);
    User fromUserRegisterDTOToUser(UserRegisterDTO userRegisterDTO);
    UserDTO fromUserToUserDTO(User user);
    UserRegisterDTO fromUserToUserRegisterDTO(User user);
    UserRegisterDTO fromUserDTOtoUserRegisterDTO(UserDTO userDTO);

}
