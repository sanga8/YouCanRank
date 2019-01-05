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
import com.ycr.DAO.*;

@Controller
public class TopController {

    @Autowired
    private TopDao topDao;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
	public String Register(@ModelAttribute(name="createForm") Top top, Model model) {
		
		String titre = top.getTitre();
		Integer point = top.getPoint();
		String link = top.getLink();

		topDao.insertBdd(titre,point,link);
		
		return "index";
	}

}