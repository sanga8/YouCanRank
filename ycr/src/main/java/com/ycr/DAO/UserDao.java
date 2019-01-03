package com.ycr.DAO;

import java.util.List;
import javax.transaction.Transactional;
import com.ycr.Model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserDao extends CrudRepository<User,Integer> {
	List<User> findByPseudo (String pseudo);
	List<User> findAll();

	/*
	@Query("SELECT username FROM utilisateur where id=:id")
	List<User> takeBdd(@Param ("id") int id);
	*/
	@Query("SELECT password FROM User WHERE pseudo = :pseudo ")
	String authentificationUser(@Param ("pseudo") String pseudo);
	
	@Modifying
	@Query(value ="INSERT INTO User (pseudo, password) VALUES (:pseudo, :password)", nativeQuery =true)
	@Transactional
	void insertBdd(@Param ("pseudo") String string, @Param ("password") String string2);
}