package com.example.springboothiber.repositories;

import com.example.springboothiber.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    public Role getRoleByName(String name);
}
