package com.ycr.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.ycr.Model.UserTop;

@Repository("userTopRepository")
public interface UserTopRepository extends JpaRepository<UserTop, Long> {
 
 @Query(value = "SELECT * FROM UserTop WHERE id_user = :id_top", 
 nativeQuery = true)
 List<UserTop> topVotedByThisUser(@Param ("id_top") Integer id_top);
 
 
 @Query(value = "SELECT * FROM UserTop WHERE id_user = :id_user", 
 nativeQuery = true)
 UserTop userTopByUserId(@Param ("id_user") Integer id_user);

 List<UserTop> findAll();
}