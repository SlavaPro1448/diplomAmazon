package com.example.InternetShop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity(name = "roles")
@Data
public class Role
{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy="role")
    private List<User> users;
}
