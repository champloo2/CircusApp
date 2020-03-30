package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dmacc.repository.ApparatusRepository;

@Controller
public class WebController {
	
	@Autowired
	ApparatusRepository repo;
	
	@GetMapping("/viewAll")
	public String viewAllApparatuses(Model model) {
	
	// "ListApparatuses" will use the "apparatuses" to identify the item it is working with
	//on ListApparatuses , "apparatuses" should match "apparatuses" below
	model.addAttribute("apparatuses", repo.findAll());
	return "ListApparatuses";
	}

}
