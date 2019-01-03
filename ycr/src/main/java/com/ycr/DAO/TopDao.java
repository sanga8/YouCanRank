package com.ycr.DAO;

import java.util.List;
import javax.transaction.Transactional;
import com.ycr.Model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TopDao extends CrudRepository<User,Integer> {

    
	@Modifying
	@Query(value ="INSERT INTO User (titre, point) VALUES (:titre, :point)", nativeQuery =true)
	@Transactional
	void insertBdd(@Param ("titre") String titre, @Param ("point") Integer point);
}