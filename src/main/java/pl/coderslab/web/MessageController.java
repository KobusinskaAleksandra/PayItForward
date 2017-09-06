package pl.coderslab.web;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.coderslab.entity.Messages;
import pl.coderslab.entity.Users;
import pl.coderslab.repository.MessagesRepository;
import pl.coderslab.repository.UsersRepository;

@Controller
public class MessageController {

	@Autowired
	MessagesRepository messagesRepository;
	@Autowired
	UsersRepository usersRepository;
	
	@ModelAttribute(value="users")
	public List<Users> users () {
		return usersRepository.findAll();
	}
	
	@RequestMapping(value="/messages", method=RequestMethod.GET)
	public String messagesView (Model model, HttpServletRequest request) {	
	model.addAttribute("sent", new Messages());
	model.addAttribute("inbox", messagesRepository.findByRecipientId((long)request.getSession().getAttribute("login")));	
	return "message";
	}
		
	@RequestMapping(value="/messages", method=RequestMethod.POST)
	public String messagesPostView (Model model, @ModelAttribute Messages sent, HttpServletRequest request) {	
	sent.setSender((usersRepository.findById((long)request.getSession().getAttribute("login"))));
	sent.setSend(LocalDateTime.now());
	messagesRepository.save(sent);
	model.addAttribute("sent", new Messages());
	model.addAttribute("inbox", messagesRepository.findByRecipientId((long)request.getSession().getAttribute("login")));
	return "message";
	}
}