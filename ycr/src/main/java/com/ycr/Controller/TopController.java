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

		Question q2 = new Question();
		model.addAttribute("q2",q2);

		Question q3 = new Question();
		model.addAttribute("q3",q3);

		Question q4 = new Question();
		model.addAttribute("q4",q4);

		Question q5 = new Question();
		model.addAttribute("q5",q5);

		Question q6 = new Question();
		model.addAttribute("q6",q6);

		Question q7 = new Question();
		model.addAttribute("q7",q7);

		Question q8 = new Question();
		model.addAttribute("q8",q8);

		Question q9 = new Question();
		model.addAttribute("q9",q9);

		Question q10 = new Question();
		model.addAttribute("q10",q10);

		Question q11 = new Question();
		model.addAttribute("q11",q11);

		Question q12 = new Question();
		model.addAttribute("q12",q12);

		Question q13 = new Question();
		model.addAttribute("q13",q13);

		return "create";
	}

    @PostMapping(value = "/create")
	public String Register(Top top,Question q1, Question q2, Question q3, Question q4, Question q5, Question q6, Question q7
	, Question q8, Question q9, Question q10, Question q11, Question q12, Question q13, Model model) {
		
		topDao.save(top);

		q1.setTop_id(top.getId());
		questionRepository.save(q1);

		q2.setTop_id(top.getId());
		questionRepository.save(q2);

		q3.setTop_id(top.getId());
		questionRepository.save(q3);

		q4.setTop_id(top.getId());
		questionRepository.save(q4);

		q5.setTop_id(top.getId());
		questionRepository.save(q5);

		q6.setTop_id(top.getId());
		questionRepository.save(q6);

		q7.setTop_id(top.getId());
		questionRepository.save(q7);

		q8.setTop_id(top.getId());
		questionRepository.save(q8);

		q9.setTop_id(top.getId());
		questionRepository.save(q9);

		q10.setTop_id(top.getId());
		questionRepository.save(q10);

		q11.setTop_id(top.getId());
		questionRepository.save(q11);

		q12.setTop_id(top.getId());
		questionRepository.save(q12);

		q13.setTop_id(top.getId());
		questionRepository.save(q13);
		
		return "index";
		
	}
}