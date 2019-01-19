package com.ycr.DAO;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.ycr.Model.Question;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface QuestionRepository extends CrudRepository<Question,Integer> {

    @Query(value = "SELECT * FROM Question WHERE id_top = :id_top ORDER BY Point DESC; ", 
    nativeQuery = true)
    List<Question> questionByIdTopQuestions(@Param ("id_top") Integer id_top);

    @Query(value = "SELECT * FROM Question WHERE id_top = :id_top", 
    nativeQuery = true)
    List<Question> questionByIdTop(@Param ("id_top") Integer id_top);


    @Modifying
	@Query(value ="UPDATE Question SET point = point+1 WHERE id = :id", nativeQuery =true)
	@Transactional
    void update(@Param ("id") Integer id);
    
    Optional<Question> findById(Integer id);



	//Question findAllById_top(Integer id_top);

}