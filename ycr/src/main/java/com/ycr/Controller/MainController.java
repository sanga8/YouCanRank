package com.ycr.Controller;

import com.ycr.Model.User;
import com.ycr.Service.UserService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.ycr.DAO.CategorieDao;
import com.ycr.DAO.TopDao;
import com.ycr.DAO.UserRepository;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {

	@Autowired
	private UserService userService;
	@Autowired
	private TopDao topDao;
	@Autowired
	private CategorieDao categorieDao;
	@Autowired
	private UserRepository userRepository;


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
	   model.addAttribute("msg2", "This username is already used");
	   return "register";
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


	@GetMapping(value="/getTop")
	@ResponseBody
	List<Top> getTags(@RequestParam String titre) {

		System.out.println(topDao.search(titre));
		return topDao.search(titre);
		
	}


	@GetMapping(value="/search/{top.titre}")
	public String toCreate(@PathVariable(value="top.titre") String titre, Model model) {

		model.addAttribute("top", topDao.search(titre));
		model.addAttribute("categorie", categorieDao.findAll());

		return "resultat";
	}
	

	@GetMapping(value="/myaccount")
    public String myaccount(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepository.findByUsername(authentication.getName());
		
		model.addAttribute("username",user.getUsername());
		model.addAttribute("usermail",user.getEmail());
        return "myaccount";
	}
	
	@PostMapping(value="/changePassword")
	public String changeUserPassword(String newPassword, String oldPassword, Model model){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepository.findByUsername(authentication.getName());

		if (userService.encode().matches(oldPassword, user.getPassword()) ){
		userService.changePassword(user, newPassword);
		model.addAttribute("msg", "Your password has been changed successfully!");
		return "myaccount";
		}
		else{
			model.addAttribute("msg2", "Your current password is incorrect");
			return "myaccount";
		}

	}
	@PostMapping(value="/changeEmail")
	public String changeUserEmail(String newEmail, Model model){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepository.findByUsername(authentication.getName());

		userService.changeEmail(user, newEmail);
		model.addAttribute("msg", "Your email has been changed successfully!");
		return "myaccount";
	}

}