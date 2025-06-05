package tw.danielchiang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoutingController {

	@GetMapping({"/", "/index"})
	public String index() {
		return "/index";
	}

	@GetMapping("/secure/login")
	public String login() {
		return "/secure/login";
	}
	
	@GetMapping("/pages/institution")
	public String institution() {
		return "/pages/institution";
	}
	
	@GetMapping("/pages/display")
	public String display() {
		return "/pages/display";
	}
	
}
