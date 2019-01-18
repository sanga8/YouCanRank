package com.ycr.Service;

import com.ycr.Model.User;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public interface UserService {
  
 public User findUserByUsername(String username);
 
 public void saveUser(User user);

 public void changePassword(User user, String password);

 public BCryptPasswordEncoder encode();

}