package com.daleksic.errorhandlingdemo.repository;

import com.daleksic.errorhandlingdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
