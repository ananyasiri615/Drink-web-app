package com.ars.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ars.entity.Drink;
import com.ars.repository.DrinkRepository;

@Controller
@RequestMapping("/drink")
public class DrinkController {

	@Autowired
	private DrinkRepository drinkRepository;
	
	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("appName", "Spring boot web application.");
		return "home";
	}

	@RequestMapping("/display")
	public String displayDrinkInfo(Model model) {

		List<Drink> drinks = (List<Drink>) drinkRepository.findAll();

		model.addAttribute("drinks", drinks);
		model.addAttribute("msg", "Welcome to Drinks Menu.");

		return "displayDrink";
	}

	@GetMapping("/editForm/{id}")
	public String editForm(@PathVariable String id, Model model) {

		Drink drink = drinkRepository.findById(Integer.parseInt(id)).get();

		model.addAttribute("drink", drink);

		return "editDrink";
	}

	@RequestMapping("/edit")
	public String editDrinkInfo(@ModelAttribute Drink drink, Model model) {

		drinkRepository.save(drink);

		List<Drink> drinks = (List<Drink>) drinkRepository.findAll();

		model.addAttribute("drinks", drinks);
		model.addAttribute("msg", "Drink has been edited.");

		return "displayDrink";
	}

	@GetMapping("/addForm")
	public String addForm() {

		return "addDrink";
	}

	@PostMapping("/add")
	public String create(@ModelAttribute Drink drink, Model model) {

		drinkRepository.save(drink);

		List<Drink> drinks = (List<Drink>) drinkRepository.findAll();
		model.addAttribute("drinks", drinks);
		model.addAttribute("msg", "Drink has been added.");

		return "displayDrink";
	}

}
