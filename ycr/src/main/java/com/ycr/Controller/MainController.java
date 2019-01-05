package com.ycr.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.ycr.DAO.TopDao;
import com.ycr.Model.Top;;


@Controller
public class MainController {

private TopDao topDao;

	@Autowired
	public void setTopDao(TopDao topDao) {
		this.topDao = topDao;
	}

	@GetMapping(value={"/index",""})
	public String toIndex(Model model) {
		
		model.addAttribute("top", topDao.findFirst10ByOrderByPointDesc());
		//model.addAttribute("top", topDao.findAll(new Sort(Sort.Direction.DESC, "point")));
		
		return "index";
	}
	



    @GetMapping(value="/create")
	public String toCreate() {
		return "create";
    }
    

	

}