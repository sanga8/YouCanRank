package com.ycr.Repository;

import org.springframework.data.repository.CrudRepository;

import com.ycr.Model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    
}
