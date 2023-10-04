package org.java.app.controller;


import java.util.List;

import org.java.app.db.pojo.Pizza;
import org.java.app.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class PizzaController {
	
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("/")
	public String getIndex(Model model) {
		
		List<Pizza> pizzas = pizzaService.findAll();
		model.addAttribute("pizzas", pizzas);
		
		return "home";
	}

}
