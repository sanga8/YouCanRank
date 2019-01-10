package com.ycr.DAO;

import java.util.List;
import javax.transaction.Transactional;

import com.ycr.Model.Top;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TopDao extends CrudRepository<Top,Integer> {
	
	List<Top> findFirst10ByOrderByPointDesc();
	
	
	//Top getTopById(Integer id);



}