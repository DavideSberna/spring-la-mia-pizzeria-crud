package org.java.app;

import org.java.app.db.pojo.Pizza;
import org.java.app.db.serv.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner {
	
	
	@Autowired
	private PizzaService pizzaService;

	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Pizza pizza1 = new Pizza("Margherita", "Pizza leggera, semplice e facile da digerire", "margherita.jpg", 20.00);
		Pizza pizza2 = new Pizza("Mangia e taci", "Pizza leggera, semplice e facile da digerire", "mangia-e-taci.jpg", 30.20);
		Pizza pizza3 = new Pizza("Bufalina", "Pizza leggera, semplice e facile da digerire", "bufalina.jpg", 22.90);
		Pizza pizza4 = new Pizza("Bella Brescia", "Pizza leggera, semplice e facile da digerire", "bella-brescia.jpg", 32.60);
		
		pizzaService.save(pizza1);
		pizzaService.save(pizza2);
		pizzaService.save(pizza3);
		pizzaService.save(pizza4);
		
	}

}
