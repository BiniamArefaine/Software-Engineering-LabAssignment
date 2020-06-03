package edu.miu.cs425.eRegistrar.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RegistrarHomePageController {
	
	@GetMapping(value = {"/", "/eregistrar", "/index", "eregistrar/home"})
	public String displayHomePage() {
		
		return "home/index";
	}

}
