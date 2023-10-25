package com.example.testgroup.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity(name = "users")
@Data
public class User
{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    private String email;
    private String password;
    private String name;

    @ManyToOne
    private Role role;

    @Override
    public String toString() {
        return "";
    }

}
