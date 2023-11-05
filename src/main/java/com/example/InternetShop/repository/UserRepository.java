package com.example.InternetShop.repository;

import com.example.InternetShop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
    User findByName(String name);
    User findByEmail(String email);
}
