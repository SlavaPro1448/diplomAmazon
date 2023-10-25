package com.example.testgroup.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@AllArgsConstructor
public class TestController
{
    @GetMapping
    @Secured("user2")
    public String test() {
        var res = new StringBuilder();
        for(int i =1; i< 1_000_000; i++) {
            res.append("booasdfoasdofsaodfoasd");
        }
        return res.toString();
    }
}
