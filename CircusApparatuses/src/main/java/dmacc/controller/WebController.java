package dmacc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Apparatus;
import dmacc.beans.Maneuver;
import dmacc.repository.ApparatusRepository;
import dmacc.repository.ManeuversRepository;

@Controller
public class WebController {
	
	@Autowired
	ApparatusRepository repo;
	
	@Autowired
	ManeuversRepository mRepo;
	
	//when another 
	@GetMapping({"/", "viewAll"})
	public String viewAllApparatuses(Model model) 
	{
	if(repo.findAll().isEmpty()) 
	{
	return addNewApparatus(model);
	}
	model.addAttribute("apparatuses", repo.findAll());
	return "ListApparatuses";
	}
	
	//earlier "view all" was broken, had something to do with if statement for empty
	// "ListApparatuses" will use the "apparatuses" to identify the item it is working with
	//on ListApparatuses , "apparatuses" should match "apparatuses" below

	
	
	
	//comes from templates? //comes from a form
	@GetMapping("/inputApparatus")
	public String addNewApparatus(Model model) 
	{
	Apparatus a = new Apparatus();
	model.addAttribute("newApparatus", a);
	return "inputApparatus";  //earlier, this said "index" and it was not working
	}
	
	
	
	//comes from static
	@PostMapping("/inputApparatus")
	public String addNewApparatus(@ModelAttribute Apparatus c,Model model) {
	repo.save(c);
	return viewAllApparatuses(model);
	} 
	
	@GetMapping("/edit/{id}")
	public String showUpdateContact(@PathVariable("id") long id,Model model) 
	{
	Apparatus a = repo.findById(id).orElse(null);
	model.addAttribute("newApparatus", a);
	return "inputApparatus";
	}
	
	@PostMapping("/update/{id}")
	public String reviseContact(Apparatus c, Model model) {
	repo.save(c);
	return viewAllApparatuses(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) 
	{
	Apparatus c = repo.findById(id).orElse(null);
	repo.delete(c);
	return viewAllApparatuses(model);
	}

	
	
	
	@GetMapping("/listManeuversByAppId/{id}")
	public String viewManeuversByAppId(@PathVariable("id") long id, Model model) 
	{
	Apparatus c = repo.findById(id).orElse(null);
	List<Maneuver> listByApp=new ArrayList<Maneuver>();
	for (Maneuver m : mRepo.findAll())
	{
		if(c.getId() == m.getApparatus().getId())
		{
		listByApp.add(m);
		}
	} 
	
	model.addAttribute("maneuversByApp", listByApp);
	return "ListManeuvers";
	}
	
	
	@GetMapping("/inputManeuver/{id}")
	public String addNewManeuver(@PathVariable("id") long id, Model model) 
	{
	Apparatus c = repo.findById(id).orElse(null);
	Maneuver m = new Maneuver(c);
	model.addAttribute("newManeuver", m);
	return "inputManeuver";  //earlier, this said "index" and it was not working
	}
	
	
	
	//comes from static
	@PostMapping("/inputManeuver")
	public String addNewManeuver(@ModelAttribute Maneuver c,Model model) {
	mRepo.save(c);
	return viewAllApparatuses(model);
	} 
	
	
	
	

}
