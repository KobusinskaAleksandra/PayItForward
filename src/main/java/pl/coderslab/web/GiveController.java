package pl.coderslab.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.entity.Requests;
import pl.coderslab.entity.Responses;
import pl.coderslab.repository.RequestsRepository;
import pl.coderslab.repository.ResponseRepository;
import pl.coderslab.repository.UsersDetailsRepository;

@Controller
public class GiveController {
	
	@Autowired
	RequestsRepository requestRepository;
	@Autowired
	ResponseRepository responseRepository;
	@Autowired
	UsersDetailsRepository usersDetailsRepository;
	
	@ModelAttribute(value="requests")
	public List<Requests> getRequests() {
		return requestRepository.findAll();
	}
	

	@RequestMapping(value="/give", method=RequestMethod.GET)
	public String getGetView (Model model) {
		model.addAttribute("response", new Responses());
		return "give";
	}
	
	
	@RequestMapping(value="/give", method=RequestMethod.POST)
	public String getPostView (HttpServletRequest request, Model model) {
		Responses response = new Responses();
		if (request.getSession().getAttribute("login")!=null) {
		response.setUser(usersDetailsRepository.findById((Long) request.getSession().getAttribute("login")));
		response.setRequest(requestRepository.findById(Long.parseLong(request.getParameter("requestId"))));
		responseRepository.save(response);
		}
		else {
		
		}
		return "give";
	}
	
}