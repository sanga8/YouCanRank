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

	@GetMapping(value="/create")
	public String toCreate() {
		return "create";
	}

    @RequestMapping(value = "/create", method = RequestMethod.POST)
	public String Register(@ModelAttribute(name = "createForm") Top top, ArrayList<Question> questions, Model model) {

		String titre = top.getTitre();
		String link = top.getLink();
		Integer id_categorie = top.getId_categorie();

		
		for (int i=0;i<questions.size();++i){
		String titreQuestion = questions.get(i).getTitre();
		String linkQuestion =questions.get(i).getLink();
		Integer id_top= top.getId();


		topDao.insertQuestionBdd(titreQuestion, linkQuestion, id_top);	
		}

		topDao.insertTopBdd(titre,link,id_categorie);
		
		return "index";
	}



}