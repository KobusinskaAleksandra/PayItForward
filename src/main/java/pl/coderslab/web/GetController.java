package pl.coderslab.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.coderslab.entity.Category;
import pl.coderslab.entity.Cities;
import pl.coderslab.entity.Requests;
import pl.coderslab.repository.CategoryRepository;
import pl.coderslab.repository.CitiesRepository;
import pl.coderslab.repository.RequestsRepository;
import pl.coderslab.repository.UsersDetailsRepository;

@Controller
@SessionAttributes({"", ""})
public class GetController {
	
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	CitiesRepository citiesRepository;
	@Autowired
	RequestsRepository requestRepository;
	@Autowired
	UsersDetailsRepository usersRepository;
	

	
	@ModelAttribute(value="cities")
	public List<Cities> getCities() {
		return citiesRepository.findAll();
	}
	

	@RequestMapping(value="/get", method=RequestMethod.GET)
	public String getGetView (Model model, @ModelAttribute Category categories, @ModelAttribute Requests request, BindingResult result) {
		model.addAttribute("categories", categoryRepository.findAll());
		model.addAttribute("request", new Requests());
		return "get";
	}
	
	
	@RequestMapping(value="/get", method=RequestMethod.POST)
	public String getPostView (Model model, @ModelAttribute Requests request, BindingResult result, HttpServletRequest req) {
		request.setUser((usersRepository.findById(((long)req.getSession().getAttribute("login")))));
		requestRepository.save(request);
		model.addAttribute("categories", categoryRepository.findAll());
		model.addAttribute("request", new Requests());
		return "redirect:give";
	}
	
}
