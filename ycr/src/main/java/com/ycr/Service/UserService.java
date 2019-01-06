package com.ycr.Service;

import com.ycr.Model.User;

public interface UserService {
  
 public User findUserByUsername(String username);
 
 public void saveUser(User user);
}