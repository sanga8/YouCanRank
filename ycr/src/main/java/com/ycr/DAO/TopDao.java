package com.ycr.DAO;

import java.util.List;
import javax.transaction.Transactional;

import com.ycr.Model.Top;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TopDao extends CrudRepository<Top,Integer> {
	
	//List<Top> findAll(Sort sort);
	
	List<Top> findFirst10ByOrderByPointDesc();
	
	
	//Top getTopById(Integer id);

	/*
	@Modifying
	@Query(value ="INSERT INTO top (titre, link, id_categorie) VALUES (:titre, :link, :id_categorie)", nativeQuery =true)
	@Transactional
	void insertTopBdd(@Param ("titre") String string, @Param ("link") String string2, @Param ("id_categorie") Integer string3);

	@Modifying
	@Query(value ="INSERT INTO question (titre, link, id_top) VALUES (:titre, :link, :id_top)", nativeQuery =true)
	@Transactional
	void insertQuestionBdd(@Param ("titre") String string, @Param ("link") String string2, @Param ("id_top") Integer string3);
	*/
	


}