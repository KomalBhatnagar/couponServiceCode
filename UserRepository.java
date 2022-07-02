package com.komal.security;

import org.springframework.data.jpa.repository.JpaRepository;

import com.komal.security.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
