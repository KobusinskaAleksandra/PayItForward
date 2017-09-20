package pl.coderslab.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.coderslab.bCrypt.BCrypt;
import pl.coderslab.entity.Cities;
import pl.coderslab.entity.Loged;
import pl.coderslab.entity.Users;
import pl.coderslab.entity.UsersDetails;
import pl.coderslab.repository.CitiesRepository;
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
	@Autowired
	Validator valid;
	
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registerGetView (Model model, @ModelAttribute Cities cities, BindingResult result, HttpServletRequest request) {
	model.addAttribute("cities", citiesRepository.findAll());
	model.addAttribute("userDetails", new UsersDetails());
	model.addAttribute("users", new Users());
	model.addAttribute("loged", new Loged());
	return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerPostView (final RedirectAttributes redirectAttributes, HttpServletRequest request, Model model, @ModelAttribute Loged log, @ModelAttribute UsersDetails userDetails, @ModelAttribute Users users) {
		if(!log.isChecked()) { 
				users.setPassword( (BCrypt.hashpw(users.getPassword(), BCrypt.gensalt())));
				userDetails.setUser(users);
				usersRepository.save(users);
				usersDetailsRepository.save(userDetails);
				request.getSession().setAttribute("login", users.getId());
				return "redirect: register";
			}				
		else { 
				if (BCrypt.checkpw(log.getPassword(), usersRepository.findByLogin(log.getLogin()).getPassword())) {
					request.getSession().setAttribute("login", usersRepository.findByLogin(log.getLogin()).getId());
					return "index";
				}
				else
					redirectAttributes.addFlashAttribute("loginPassError", "Wrong password, try again!");
					model.addAttribute("userDetails", new UsersDetails());
					model.addAttribute("users", new Users());
					log.setPassword(null);
					model.addAttribute("loged", new Loged());
					return "redirect:register";
			}	
	}
}