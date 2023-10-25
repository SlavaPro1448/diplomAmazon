package com.example.testgroup.mapper;

import com.example.testgroup.dto.UserDTO;
import org.mapstruct.Mapper;
import com.example.testgroup.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper
{
    User toUser(UserDTO userDTO);
    UserDTO toUserDTO(User user);
}
