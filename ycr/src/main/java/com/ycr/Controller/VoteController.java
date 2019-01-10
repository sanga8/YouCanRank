package com.ycr.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ycr.Model.*;

import java.util.ArrayList;
import java.util.List;

import com.ycr.DAO.*;

import com.ycr.DTO.*;

@Controller
public class VoteController {

    @Autowired
	private TopDao topDao;
	@Autowired
	private QuestionRepository questionRepository;
	

	@GetMapping(value="/vote/{top.titre}")
	public String toCreate(Model model) {

  
		return "vote";
	}

    @PostMapping(value = "/vote")
	public String Register(Model model) {

	
		return "vote";

	}
}