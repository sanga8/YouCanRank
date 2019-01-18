package com.ycr.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.ycr.Config.*;

import com.ycr.Model.User;
import com.ycr.DAO.UserRepository;

import java.util.Arrays;
import java.util.HashSet;

@Service("userService")
public class UserServiceImpl implements UserService {
 
 @Autowired
 private UserRepository userRepository;
 
 @Autowired
 private BCryptPasswordEncoder bCryptPasswordEncoder;

 @Override
 public User findUserByUsername(String username) {
  return userRepository.findByUsername(username);
 }

 @Override
 public void saveUser(User user) {
  user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
  
  user.setActive(1);
  userRepository.save(user);
 }

 @Override
 public void changePassword(User user, String password) {
  user.setPassword(bCryptPasswordEncoder.encode(password));
  userRepository.save(user);
 }

 @Override
 public BCryptPasswordEncoder encode(){
    return bCryptPasswordEncoder;
 }




}