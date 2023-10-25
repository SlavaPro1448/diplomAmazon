package com.example.testgroup.repository;

import com.example.testgroup.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Integer>
{
}
