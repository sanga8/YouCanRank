package com.ycr.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.ycr.Model.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import com.ycr.DAO.*;

import com.ycr.DTO.*;

@Controller
public class VoteController {


	CreateDTO createDTO = new CreateDTO();

	@Autowired
	private TopDao topDao;
	@Autowired
	private CategorieDao categorieDao;
	@Autowired
	private QuestionRepository questionRepository;


	@GetMapping(value="/vote/{top.id}")
	public String Getcreate(@PathVariable(value="top.id") String id, Model model) {

		Integer id_top = Integer.parseInt(id);

		Top top = topDao.findById(id_top).get();
		
		List<Question> questionList = questionRepository.questionByIdTop(id_top);
		
		createDTO.setTop(top);
		createDTO.setQuestionList(questionList);
		
		model.addAttribute("createDTO",createDTO);
		model.addAttribute("categorie", categorieDao.findAll());

		return "vote";
	}


	@PostMapping(value="/Addvote/{id}")
	public void Vote(@PathVariable(value = "id") String id) {

		Integer id_question = Integer.parseInt(id);
		questionRepository.update(id_question);

	}


	@GetMapping(value="/topresult/{top.id}")
	public String getResult(@PathVariable(value="top.id") String id, Model model) {

		Integer id_top = Integer.parseInt(id);

		Top top = topDao.findById(id_top).get();
		
		List<Question> questionList = questionRepository.questionByIdTopQuestions(id_top);
		
		createDTO.setTop(top);
		createDTO.setQuestionList(questionList);
		
		
		model.addAttribute("createDTO",createDTO);
		model.addAttribute("categorie", categorieDao.findAll());

		return "topresult";
	}
}