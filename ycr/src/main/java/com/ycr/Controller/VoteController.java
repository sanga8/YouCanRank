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
	Map<Question,Integer> Voted=new TreeMap<Question,Integer>();
	

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

		CreateDTO createDTO = new CreateDTO(top, nonVoted);
		model.addAttribute("createDTO",createDTO);
		model.addAttribute("categorie", categorieDao.findAll());

		return "vote";
	}

    @PostMapping(value = "/vote")
	public String Register(Model model) {

	
		return "vote";

	}

	@PostMapping(value="/Addvote/{id}")
	public void Vote(@PathVariable(value="id") String id, Model model){
		
		nonVoted.remove(1);
		nonVoted.remove(0);

		Integer id_question = Integer.parseInt(id);
		
        questionRepository.update(id_question);
            
	}
}