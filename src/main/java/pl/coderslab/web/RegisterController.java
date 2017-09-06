package pl.coderslab.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.coderslab.entity.Cities;
import pl.coderslab.entity.Loged;
import pl.coderslab.entity.Users;
import pl.coderslab.entity.UsersDetails;
import pl.coderslab.repository.CategoryRepository;
import pl.coderslab.repository.CitiesRepository;
import pl.coderslab.repository.RequestsRepository;
import pl.coderslab.repository.UsersDetailsRepository;
import pl.coderslab.repository.UsersRepository;

@Controller
@SessionAttributes("login")
public class RegisterController {
	
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private UsersDetailsRepository usersDetailsRepository;
	@Autowired
	private CitiesRepository citiesRepository;
	

	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registerGetView (Model model, @ModelAttribute Cities cities, BindingResult result, HttpServletRequest request) {
	model.addAttribute("cities", citiesRepository.findAll());
	model.addAttribute("userDetails", new UsersDetails());
	model.addAttribute("user", new Users());
	model.addAttribute("loged", new Loged());
	return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerPostView (HttpServletRequest request, Model model, @ModelAttribute Loged log, @ModelAttribute UsersDetails userDetails, @ModelAttribute Users user) {
		if(!log.isChecked()) { 
				userDetails.setUser(user);
				usersRepository.save(user);
				usersDetailsRepository.save(userDetails);
				request.getSession().setAttribute("login", user.getId());
				}
			else 
				request.getSession().setAttribute("login", usersRepository.findByLogin(log.getLogin()).getId());
		return "index";
	}


}