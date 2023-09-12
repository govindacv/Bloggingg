package com.blogging.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogging.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
