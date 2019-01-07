package com.ycr.DAO;

import java.awt.print.Pageable;
import java.util.List;
import javax.transaction.Transactional;

import com.ycr.Model.Top;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TopDao extends CrudRepository<Top,Integer> {
	
	//List<Top> findAll(Sort sort);
	
	List<Top> findFirst10ByOrderByPointDesc();
	
	
	Top getTopById(Integer id);

	@Modifying
	@Query(value ="INSERT INTO top (titre, point, link, categorie_id) VALUES (:titre, :point, :link, :categorie_id)", nativeQuery =true)
	@Transactional
	void insertBdd(@Param ("titre") String string, @Param ("point") Integer string2, @Param ("link") String string3, @Param ("categorie_id") Integer string4);



}