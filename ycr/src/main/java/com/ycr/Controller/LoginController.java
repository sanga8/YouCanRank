package com.ycr.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ycr.Model.User;
import com.ycr.DAO.*;

@Controller
public class LoginController {

  @Autowired
  private UserDao userDao;

	@GetMapping(value="/login")
	public String getLoginForm() {
		return "login";
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String Login(@ModelAttribute(name="loginForm") User user, Model model) {
		String pseudo = user.getPseudo();
		String password = user.getPassword();
   		String authentification = userDao.authentificationUser(pseudo);
    
		if (authentification!=null) {
			if (authentification.equals(password)) {
				return "index";
			}
			else {
				return "login";
			}
		}
		return "login";
	}
	

}