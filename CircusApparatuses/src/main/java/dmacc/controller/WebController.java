package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import dmacc.repository.ApparatusRepository;

@Controller
public class WebController {
	
	@Autowired
	ApparatusRepository repo;

}
