package org.java.app.controller;


import java.util.List;

import org.java.app.db.pojo.Pizza;
import org.java.app.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class PizzaController {
	
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("/")
	public String getIndex(
	        @RequestParam(name = "nome", required = false) String nome,
	        @RequestParam(name = "voto", required = false) Integer voto,
	        @RequestParam(name = "allergeni", required = false) String allergeniStr,
	        Model model) {

	    List<Pizza> pizzas = null;
	    
	    boolean allergeni = false;
	    
	    if (allergeniStr != null && !allergeniStr.isEmpty()) {
	        allergeni = allergeniStr.equals("1");
	    }

	    if (nome == null && voto == null && !allergeni) {
	        pizzas = pizzaService.findAll();
	    } else {
	        if (voto == null) {
	            voto = 0;
	        }
	        pizzas = pizzaService.findByNomeContaining(nome, voto, allergeni);
	    }

	    model.addAttribute("pizzas", pizzas);
	    model.addAttribute("nome", nome);
	    model.addAttribute("voto", voto);
	   
	    

	    return "home";
	}
	
	@GetMapping("/pizza/{id}")
	public String getPizzaId(@PathVariable int id, Model model) {
		
		Pizza pizza = pizzaService.findById(id);
		List<Pizza> pizzas = pizzaService.findByIdNotLike(id);
		
		
		model.addAttribute("pizzas", pizzas);
		model.addAttribute("pizza", pizza);
		
		return "pizza-show";
		
	}
	

}
