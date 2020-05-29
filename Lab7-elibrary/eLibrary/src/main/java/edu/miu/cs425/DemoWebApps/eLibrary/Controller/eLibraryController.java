package edu.miu.cs425.DemoWebApps.eLibrary.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class eLibraryController {
	
	@GetMapping(value = {"/" , "/elibrary", "/elibrary/home"})
	public String displayPage() {
		
		return "home/index";
	}

}
