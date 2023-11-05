package com.example.InternetShop.mapper;

import com.example.InternetShop.dto.UserDTO;
import org.mapstruct.Mapper;
import com.example.InternetShop.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper
{
    User toUser(UserDTO userDTO);
    UserDTO toUserDTO(User user);
}
