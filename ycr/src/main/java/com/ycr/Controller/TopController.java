package com.ycr.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ycr.Model.*;

import java.util.ArrayList;

import com.ycr.DAO.*;

@Controller
public class TopController {

    @Autowired
	private TopDao topDao;
	@Autowired
	private QuestionRepository questionRepository;

	@GetMapping(value="/create")
	public String toCreate(Model model) {

		Top top = new Top();
		model.addAttribute("top",top);
		
		Question q1 = new Question();
		model.addAttribute("q1",q1);
        
		return "create";
	}

    @PostMapping(value = "/create")
	public String Register(Top top,Question q1, Model model) {
		

		topDao.save(top);
		q1.setTop_id(top.getId());
		questionRepository.save(q1);
		//topDao.insertTopBdd(titre,link,id_categorie);
		

		/*
		String titreQuestion = q1.getTitre();
		String linkQuestion  = q1.getLink();
		Integer id_top= top.getId();

		topDao.insertQuestionBdd(titreQuestion, linkQuestion, id_top);
		*/
		
		return "index";
	}



}