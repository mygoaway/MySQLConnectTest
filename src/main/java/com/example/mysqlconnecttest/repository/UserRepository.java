package com.example.mysqlconnecttest.repository;

import com.example.mysqlconnecttest.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}