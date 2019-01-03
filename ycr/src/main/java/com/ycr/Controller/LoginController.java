package com.ycr.Controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.ycr.Model.User;
import com.ycr.DAO.*;

@Controller
public class LoginController {

  @Autowired
  private UserDao userDao;

	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String getLoginForm() {
		return "register";
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