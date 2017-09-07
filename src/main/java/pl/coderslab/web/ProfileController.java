package pl.coderslab.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.entity.Category;
import pl.coderslab.entity.Requests;
import pl.coderslab.entity.Users;
import pl.coderslab.entity.UsersDetails;
import pl.coderslab.repository.RequestsRepository;
import pl.coderslab.repository.ResponseRepository;
import pl.coderslab.repository.UsersDetailsRepository;
import pl.coderslab.repository.UsersRepository;
@Controller
public class ProfileController {

	@Autowired
	ResponseRepository responseRepository;
	@Autowired
	RequestsRepository requestRepository;
	@Autowired
	UsersRepository usersRepository;
	@Autowired
	UsersDetailsRepository usersDetailsRepository;
	
	
	@ModelAttribute(value="user")
	public Users getUser (HttpServletRequest req) {
	return usersRepository.findById((long)req.getSession().getAttribute("login"));
	}
	@ModelAttribute(value="userDet")
	public UsersDetails getUserDet (HttpServletRequest req) {
	return usersDetailsRepository.findByUserId((long)req.getSession().getAttribute("login"));
	}
	
	@ModelAttribute(name="yourRequests")
	public List <Requests> getResponse () {
		return requestRepository.findAll();
	}

	@RequestMapping(value="/profile", method=RequestMethod.GET)
	public String profileView (Model model, @ModelAttribute Category categories, @ModelAttribute Requests request) {
		return "profile";
	}
	
	
	@RequestMapping(value="/profile", method=RequestMethod.POST)
	public String profilePostView (Model model, HttpServletRequest req) {
		return "redirect:profile";
	}
	
}
