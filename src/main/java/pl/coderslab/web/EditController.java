package pl.coderslab.web;

import javax.servlet.http.HttpServletRequest;

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
import pl.coderslab.repository.UsersDetailsRepository;
import pl.coderslab.repository.UsersRepository;
@Controller
public class EditController {

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

	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String profileView (HttpServletRequest req, Model model, @ModelAttribute Category categories, @ModelAttribute Requests request) {
		return "edit";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String profilePostView (Model model, HttpServletRequest req, @ModelAttribute UsersDetails userDet) {
		usersDetailsRepository.saveAndFlush(userDet);
	return "profile";
	}
}