package com.ycr.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ycr.Model.*;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.ycr.DAO.*;

import com.ycr.DTO.*;

@Controller
public class TopController {

    @Autowired
	private TopDao topDao;
	@Autowired
	private CategorieDao categorieDao;
	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private UserRepository userRepository;
	

	@GetMapping(value="/create")
	public String toCreate(Model model) {

		Top top = new Top();

		Question q1 = new Question();
		Question q2 = new Question();
		Question q3 = new Question();
		Question q4 = new Question();
		Question q5 = new Question();
		Question q6 = new Question();
		Question q7 = new Question();
		Question q8 = new Question();
		Question q9 = new Question();
		Question q10 = new Question();
		Question q11 = new Question();
		Question q12 = new Question();
		Question q13 = new Question();

		List<Question> questionList= new ArrayList<Question>();

		questionList.add(q1);
		questionList.add(q2);
		questionList.add(q3);
		questionList.add(q4);
		questionList.add(q5);
		questionList.add(q6);
		questionList.add(q7);
		questionList.add(q8);
		questionList.add(q9);
		questionList.add(q10);
		questionList.add(q11);
		questionList.add(q12);
		questionList.add(q13);

		CreateDTO createDTO = new CreateDTO(top, questionList);
		model.addAttribute("createDTO",createDTO);
		model.addAttribute("categorie", categorieDao.findAll());

		return "create";
	}

    @PostMapping(value = "/create")
	public String Register(CreateDTO createDTO, Model model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepository.findByUsername(authentication.getName());

		int id_creator = user.getId();

		createDTO.getTop().setId_creator(id_creator);
		topDao.save(createDTO.getTop());

		for (int i=0; i<13;++i){
			if(createDTO.getQuestionList().get(i).getTitre().length() > 0 && createDTO.getQuestionList().get(i).getLink().length()>0){
			createDTO.getQuestionList().get(i).setTop_id(createDTO.getTop().getId());
			questionRepository.save(createDTO.getQuestionList().get(i));
			}
		}
		return "redirect:index";
	}





}