package com.ycr.DAO;

import java.util.List;
import javax.transaction.Transactional;

import com.ycr.Model.Top;
import com.ycr.Model.User;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TopDao extends CrudRepository<User,Integer> {
	List<Top> findAll(Sort sort);
    
	@Modifying
	@Query(value ="INSERT INTO top (titre, point) VALUES (:titre, :point)", nativeQuery =true)
	@Transactional
	void insertBdd(@Param ("titre") String string, @Param ("point") Integer string2);

}