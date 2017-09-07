package pl.coderslab.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	
	
	@RequestMapping("/inspiration")
	public String inspirationView (Model model, HttpServletRequest request) {	
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