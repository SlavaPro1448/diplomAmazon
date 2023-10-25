package com.example.testgroup.service;

import com.example.testgroup.dto.UserDTO;
import com.example.testgroup.mapper.UserMapper;
import com.example.testgroup.model.User;
import com.example.testgroup.repository.RoleRepository;
import com.example.testgroup.repository.UserRepository;
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
