package com.komal.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.komal.security.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
