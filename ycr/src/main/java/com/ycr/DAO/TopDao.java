package com.ycr.DAO;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.ycr.Model.Top;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TopDao extends CrudRepository<Top,Integer> {
	
	List<Top> findFirst10ByOrderByPointDesc();

	@Query(value = "SELECT * FROM Top WHERE id_categorie = :id_categorie", 
    nativeQuery = true)
    List<Top> topByIdCategorie(@Param ("id_categorie") Integer id_categorie);

	Optional<Top> findById(Integer id);

	@Query(value= "SELECT * FROM Top where titre like %:keyword%",nativeQuery = true)
	public List<Top> search(@Param("keyword") String keyword);

	@Query(value = "SELECT * FROM Top WHERE id_creator = :id_creator", 
    nativeQuery = true)
    List<Top> topByIdCreator(@Param ("id_creator") Integer id_creator);


	@Query(value = "SELECT * FROM Top WHERE id IN (SELECT id_top FROM User_Top)", 
	nativeQuery = true)
	List<Top> topWithUserTop(@Param ("id_top") Integer id_top);

	@Modifying
	@Query(value ="UPDATE Top SET point = point+1 WHERE id = :id", nativeQuery =true)
	@Transactional
    void update(@Param ("id") Integer id);
}