package javaproject.payItForward;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"", ""})
public class IndexController {

	@RequestMapping("/give")
	public String giveView () {
	return "give";
	}
	
	@RequestMapping("/get")
	public String getView () {
	return "get";
	}
	
	@RequestMapping("/inspiration")
	public String inspirationView () {
	return "inspiration";
	}
	
	@RequestMapping("/index")
	public String homeView () {
	return "index";
	}
}
