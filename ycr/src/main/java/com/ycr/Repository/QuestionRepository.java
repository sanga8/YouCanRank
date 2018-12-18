package com.ycr.Repository;

import org.springframework.data.repository.CrudRepository;

import com.ycr.Model.Question;

public interface QuestionRepository extends CrudRepository<Question, Integer> {
    
}