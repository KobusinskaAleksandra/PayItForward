package pl.coderslab.web;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.coderslab.entity.Messages;
import pl.coderslab.entity.Requests;
import pl.coderslab.entity.Responses;
import pl.coderslab.repository.MessagesRepository;
import pl.coderslab.repository.RequestsRepository;
import pl.coderslab.repository.ResponseRepository;
import pl.coderslab.repository.UsersDetailsRepository;
import pl.coderslab.repository.UsersRepository;

@Controller
public class GiveController {
	
	@Autowired
	Validator validator;
	
	@Autowired
	RequestsRepository requestRepository;
	@Autowired
	ResponseRepository responseRepository;
	@Autowired
	UsersDetailsRepository usersDetailsRepository;
	@Autowired
	UsersRepository usersRepository;
	@Autowired
	MessagesRepository messagesRepository;
	
	
	public Messages sendResponse(long idSend, long idRec) {
		Messages message = new Messages();
		message.setTitle("Someone answered at your requests");
		message.setBody("This message was sent automatically."
				+ "Sender of this message answered at your requests. "
				+ "Please contact him for a details");
		message.setSend(LocalDateTime.now());
		message.setSender(usersRepository.findById(idSend));
		message.setRecipient(usersRepository.findById(idRec));
		return message;
	}
	
	public Messages sendRequest(long idSend, long idRec) {
		Messages message = new Messages();
		message.setTitle("You answered at request");
		message.setBody("You answered at request added by sender. "
				+ "Please contact him for more details");
		message.setSend(LocalDateTime.now());
		message.setSender(usersRepository.findById(idSend));
		message.setRecipient(usersRepository.findById(idRec));
		return message;
	}
	
	
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
	public String getPostView (final RedirectAttributes redirectAttributes, HttpServletRequest request, Model model) {
		Responses response = new Responses();
		if (request.getSession().getAttribute("login")!=null) {
		response.setUser(usersDetailsRepository.findById((Long)request.getSession().getAttribute("login")));
		response.setRequest(requestRepository.findById(Long.parseLong(request.getParameter("requestId"))));
		messagesRepository.save(sendResponse((long)request.getSession().getAttribute("login"), response.getUser().getUser().getId() ));
		messagesRepository.save(sendRequest(response.getUser().getUser().getId(), (long)request.getSession().getAttribute("login") ));
		responseRepository.save(response);
		redirectAttributes.addFlashAttribute("error", "Request added to your profile");
		return "redirect:give";
		}
		else {
			redirectAttributes.addFlashAttribute("error", "Please, login first!");
			return "redirect:give";
		}
	}	
}