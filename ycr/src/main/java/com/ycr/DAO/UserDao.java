/*
package com.ycr.DAO;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import com.ycr.Model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserDao extends CrudRepository<User,Integer> {
	//List<User> findByPseudo (String username);
	//List<User> findAll();

	
	@Query("SELECT username FROM utilisateur where id=:id")
	List<User> takeBdd(@Param ("id") int id);
	

	Optional<User> findByUsername(String username);

	@Query("SELECT password FROM User WHERE username = :username ")
	String authentificationUser(@Param ("username") String username);
	
	@Modifying
	@Query(value ="INSERT INTO User (username, password) VALUES (:username, :password)", nativeQuery =true)
	@Transactional
	void insertBdd(@Param ("username") String string, @Param ("password") String string2);

}
*/