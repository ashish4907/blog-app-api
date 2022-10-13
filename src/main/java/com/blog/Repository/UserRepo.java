package com.blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
