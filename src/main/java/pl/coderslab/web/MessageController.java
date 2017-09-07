package pl.coderslab.web;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.groups.Default;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	@Autowired
	Validator validator;
	
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
	public String messagesPostView (final RedirectAttributes redirectAttributes, Model model, @ModelAttribute("sent") @Validated({Default.class}) @Valid Messages messages, BindingResult result, HttpServletRequest request) {	
	if(!result.hasErrors()) {
		messages.setSender((usersRepository.findById((long)request.getSession().getAttribute("login"))));
		messages.setSend(LocalDateTime.now());
		messagesRepository.save(messages);
		model.addAttribute("sent", new Messages());
		model.addAttribute("inbox", messagesRepository.findByRecipientId((long)request.getSession().getAttribute("login")));
	}
	else {
		if(messages.getTitle()==null)
			redirectAttributes.addFlashAttribute("errors", "temat wiadomości nie może być pusty!");
		else	
		redirectAttributes.addFlashAttribute("errors", "wiadomość nie może być krótsza niż 5 i dłuższa niż 2000 znaków!");
	}
	return "redirect:messages";
	}
}