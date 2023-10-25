package com.example.testgroup.repository;

import com.example.testgroup.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
    User findByName(String name);
    User findByEmail(String email);
}
