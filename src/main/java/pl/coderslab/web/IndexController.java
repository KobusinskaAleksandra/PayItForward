package pl.coderslab.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.coderslab.entity.Cities;
import pl.coderslab.entity.Users;
import pl.coderslab.entity.UsersDetails;
import pl.coderslab.repository.CitiesRepository;
import pl.coderslab.repository.UsersDetailsRepository;
import pl.coderslab.repository.UsersRepository;

@Controller
// @SessionAttributes("login")
public class IndexController {

	@Autowired
	private UsersRepository usersRepository;
	
	@RequestMapping("/give")
	public String giveView () {
	return "give";
	}
	
	@RequestMapping("/inspiration")
	public String inspirationView (Model model, HttpServletRequest request) {	
	model.addAttribute("users", usersRepository.findAll());
	return "inspiration";
	}
	
	@RequestMapping("/index")
	public String homeView (HttpServletRequest request) {	
	return "index";
	}

	@RequestMapping("/logout")
	public String logout (HttpServletRequest request) {
	request.getSession().setAttribute("login", null);
	return "redirect:index";
	}

}