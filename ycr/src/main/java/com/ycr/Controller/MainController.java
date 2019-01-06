package com.ycr.Controller;

import com.ycr.Model.User;
import com.ycr.Service.UserService;

import javax.validation.Valid;

import com.ycr.DAO.TopDao;
import com.ycr.Model.Top;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {

	@Autowired
	private UserService userService;

	private TopDao topDao;

	@Autowired
	public void setTopDao(TopDao topDao) {
		this.topDao = topDao;
	}

	@GetMapping(value={"","/index","/"})
	public String index(Model model) {

		/*
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();	
		if(auth!=null){
			User user = userService.findUserByUsername(auth.getName());
			model.addAttribute("userName", user.getUsername());
		}
		*/
		model.addAttribute("top", topDao.findFirst10ByOrderByPointDesc());
		 
		
		return "index";
	}



    @GetMapping(value="/create")
	public String toCreate() {
		return "create";
	}
	
	@GetMapping(value="/login")
	public String login(Model model) {
		return "login";
	   }

	@GetMapping(value="/register")
	public String register(Model model) {
		
		User user = new User();
		model.addAttribute("user", user);
		
		return "register";
	}

	@PostMapping(value= {"/register"})
 	public String createUser(@Valid User user, BindingResult bindingResult, Model model) {
  	User userExists = userService.findUserByUsername(user.getUsername());
  
  	if(userExists != null) {
   	bindingResult.rejectValue("username", "error.user", "This username already exists!");
	}

  	if(bindingResult.hasErrors()) {
	}

	else {
   	userService.saveUser(user);
   	model.addAttribute("msg", "User has been registered successfully!");
   	model.addAttribute("user", new User());
	}

	return "register";
 }

	

}