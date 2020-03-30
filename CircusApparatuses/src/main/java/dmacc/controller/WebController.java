package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Apparatus;
import dmacc.repository.ApparatusRepository;

@Controller
public class WebController {
	
	@Autowired
	ApparatusRepository repo;
	
	//when another 
	@GetMapping("/viewAll")
	public String viewAllApparatuses(Model model) {
		if(repo.findAll().isEmpty()) 
		{
		return addNewApparatus(model);
		}
	
	// "ListApparatuses" will use the "apparatuses" to identify the item it is working with
	//on ListApparatuses , "apparatuses" should match "apparatuses" below
	model.addAttribute("apparatuses", repo.findAll());
	return "ListApparatuses";
	}
	
	
	//comes from templates? //comes from a form
	@GetMapping("/inputApparatus")
	public String addNewApparatus(Model model) 
	{
	Apparatus a = new Apparatus();
	model.addAttribute("newApparatus", a);
	return "index";
	}
	
	
	//comes from static
	@PostMapping("/inputApparatus")
	public String addNewApparatus(@ModelAttribute Apparatus c,Model model) {
	repo.save(c);
	return viewAllApparatuses(model);
	}
	
	
	

}
