package com.ycr.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.ycr.Model.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import com.ycr.DAO.*;

import com.ycr.DTO.*;

@Controller
public class VoteController {

    @Autowired
	private TopDao topDao;
	@Autowired
	private CategorieDao categorieDao;
	@Autowired
	private QuestionRepository questionRepository;

	List<Question> nonVoted=new ArrayList<Question>();
	Map<Question,Integer> voted=new TreeMap<Question,Integer>();
	CreateDTO createDTO = new CreateDTO();
	

	@GetMapping(value="/vote/{top.id}")
	public String toCreate(@PathVariable(value="top.id") String id, Model model) {

		Integer id_top = Integer.parseInt(id);

		Top top = topDao.findById(id_top).get();
		
		List<Question> questionList = questionRepository.questionByIdTop(id_top);
		nonVoted.clear();
		for (Question each : questionList) {
			nonVoted.add(each);
		}

		Collections.shuffle(nonVoted);

		createDTO.setTop(top);
		createDTO.setQuestionList(nonVoted);
		
		model.addAttribute("createDTO",createDTO);
		model.addAttribute("categorie", categorieDao.findAll());

		return "vote";
	}

    @PostMapping(value = "/vote")
	public String Register(Model model) {

	
		return "vote";

	}

	@PostMapping(value="/Addvote/{id}/{i}")
	public void Vote(@PathVariable(value="id") String id,@PathVariable(value="i")  String i, Model model){
		
		Integer id_voted_true = Integer.parseInt(i);
		voted.put(nonVoted.get(id_voted_true), 1);

		Integer id_voted_false = Math.abs(id_voted_true-1);
		voted.put(nonVoted.get(id_voted_false), 0);

		nonVoted.remove(1);
		nonVoted.remove(0);

		Integer id_question = Integer.parseInt(id);
		
		questionRepository.update(id_question);
		
		createDTO.setQuestionList(nonVoted);
		model.addAttribute("createDTO",createDTO);
		model.addAttribute("categorie", categorieDao.findAll());

		//return "vote";
            
	}
}