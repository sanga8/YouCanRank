package com.ycr.Controller;

import com.ycr.Model.User;
import com.ycr.Service.UserService;

import java.util.List;

import javax.validation.Valid;

import com.ycr.DAO.CategorieDao;
import com.ycr.DAO.TopDao;
import com.ycr.Model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@Autowired
	private TopDao topDao;
	@Autowired
	private CategorieDao categorieDao;

	@GetMapping(value={"","/index","/"})
	public String index(Model model) {

		model.addAttribute("top", topDao.findFirst10ByOrderByPointDesc());
		model.addAttribute("categorie", categorieDao.findAll());
		
		return "index";
	}


 
	
	@GetMapping(value="/login")
	public String login(Model model) {
		model.addAttribute("categorie", categorieDao.findAll());
		return "login";
	   }

	@GetMapping(value="/register")
	public String register(Model model) {
		
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("categorie", categorieDao.findAll());
		
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

 @GetMapping(value="/categorie/{categorie.id}")
	public String displayCat(@PathVariable(value="categorie.id") String id, Model model) {

		Integer id_categorie = Integer.parseInt(id);

		Categorie categorie = categorieDao.findById(id_categorie).get();
	
		model.addAttribute("top",topDao.topByIdCategorie(id_categorie));
		model.addAttribute("categorie", categorieDao.findAll());
		model.addAttribute("actuelle", categorie);

		return "categorie";
	}

	

}