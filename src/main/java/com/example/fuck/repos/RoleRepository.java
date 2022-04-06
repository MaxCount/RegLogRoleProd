package com.example.fuck.repos;

import com.example.fuck.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Long> {
@Query("SELECT r from Role r where r.name = ?1")
public Role findByName(String name);
}
