package com.ycr.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ycr.Model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
 
 User findByUsername(String username);
}