package com.example.InternetShop.service;

import com.example.InternetShop.mapper.UserMapper;
import com.example.InternetShop.repository.UserRepository;
import com.example.InternetShop.dto.UserDTO;
import com.example.InternetShop.model.User;
import com.example.InternetShop.repository.RoleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService
{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public User add(UserDTO userDTO) {
        var user = userMapper.toUser(userDTO);
        user.setRole(roleRepository.findById(userDTO.getRoleId()).get());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Transactional
    public User findById(Integer id) {
        return null;
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

}
