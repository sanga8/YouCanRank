package com.ycr.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ycr.DAO.UserDao;
import com.ycr.Model.*;


@Controller

public class RegistrationController {

  @Autowired
  private UserDao userDao;

  @RequestMapping(value="/register", method=RequestMethod.GET)
  public String getRegisterForm() {
	  return "register";
  }

  @RequestMapping(value = "/register", method = RequestMethod.POST)
	public String Register(@ModelAttribute(name="registerForm") User user, Model model) {
		String pseudo = user.getPseudo();
		String password = user.getPassword();

		userDao.insertBdd(pseudo,password);
		
		return "index";
	}
}