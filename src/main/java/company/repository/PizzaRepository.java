package company.repository;

import company.model.Pizza;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PizzaRepository {

    private static final List<Pizza> pizzaList = new ArrayList<>();

    public void createPizza(Pizza pizzaToSave) {
        pizzaList.add(pizzaToSave);
    }

    public List<Pizza> readAll() {
        return pizzaList;
    }

}
