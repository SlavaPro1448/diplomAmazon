package com.example.testgroup.controller;

import com.example.testgroup.dto.UserDTO;
import com.example.testgroup.model.User;
import com.example.testgroup.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController
{
    private final UserService userService;

    @PostMapping
    public void add(@RequestBody UserDTO user) {
        userService.add(user);
    }

    @GetMapping("/{id}")
    public User find(@PathVariable Integer id) {
        return userService.findById(id);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        userService.deleteById(id);
    }


}
