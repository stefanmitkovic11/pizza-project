package company.controller;

import company.bootstrap.DataGenerator;
import company.model.Pizza;
import company.repository.PizzaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
public class DesignPizzaController {

    private final PizzaRepository pizzaRepository = new PizzaRepository();

    @PostMapping
    @RequestMapping("/design")
    public String showDesignForm(Model model) {

        model.addAttribute("cheeses", DataGenerator.cheeseTypeList);
        model.addAttribute("sauces", DataGenerator.sauceTypeList);
        model.addAttribute("toppings", DataGenerator.toppingTypeList);

        model.addAttribute("pizza",new Pizza());

        return "/design";

    }

    @PostMapping("/createPizza")
    public String processPizza(@ModelAttribute("pizza") Pizza pizza) {

        pizza.setId(UUID.randomUUID());
        pizzaRepository.createPizza(pizza);

        return "redirect:/orders/current?pizzaId=" + pizza.getId();

    }

}
