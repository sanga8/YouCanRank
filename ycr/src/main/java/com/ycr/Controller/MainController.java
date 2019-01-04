package com.ycr.Controller;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.ycr.DAO.*;
import com.ycr.Model.*;


@Controller
public class MainController {

private TopDao topDao;

	@GetMapping(value="/index")
	public String toIndex(Model model) {

		model.addAttribute("top", topDao.findAll(new Sort(Sort.Direction.DESC, "<point>")));





		return "index";
    }



    @GetMapping(value="/create")
	public String toCreate() {
		return "create";
    }
    

	

}