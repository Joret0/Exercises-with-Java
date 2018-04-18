package application.console;

import application.model.enums.Size;
import application.model.ingredients.BasicIngredient;
import application.model.labels.BasicLabel;
import application.model.shampoos.BasicShampoo;
import application.services.ingredient.IngredientServiceImpl;
import application.services.label.LabelServiceImpl;
import application.services.shampoo.ShampooServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Component
public class ConsoleRunner implements CommandLineRunner{
    private ShampooServiceImpl shampooService;
    private LabelServiceImpl labelService;
    private IngredientServiceImpl ingredientService;

    @Autowired
    public ConsoleRunner(ShampooServiceImpl shampooService, LabelServiceImpl labelService, IngredientServiceImpl ingredientService) {
        this.shampooService = shampooService;
        this.labelService = labelService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... strings) throws Exception {

        //task1SelectShampooBySize();
        //task2SelectShampoosBySizeOrLabel();
        //task3SelectShampoosByPrice();
        //task4SelectIngredientsByName();
        //task5SelectIngredientsByNames();
        //task6CountShampoosByPrice();
        //task7SelectShampoosByIngredients();
        //task8SelectShampoosByIngredientsCount();
        //task9SelectIngredientNameAndShampooBrandByName();
        task10DeleteIngredientsByName();
        task11UpdateIngredientsByPrice();
        task12UpdateIngredientsByNames();
    }

    private void task12UpdateIngredientsByNames() {
        List<String> names = new ArrayList<>();
        names.add("Lavender");
        names.add("Herbs");
        names.add("Apple");
        this.ingredientService.updatePricesInGivenList(names);
    }

    private void task11UpdateIngredientsByPrice() {
        this.ingredientService.increaseIngredientsPrice();
    }

    private void task10DeleteIngredientsByName() {
        String name = "Berry";
        this.ingredientService.deleteByName(name);
    }

    private void task9SelectIngredientNameAndShampooBrandByName() {
        String brand = "Silk Comb";
        BasicShampoo shampoo = this.shampooService.findBasicShampoosByBrand(brand);
        BigDecimal ingredientPrice = shampoo.getIngredients().stream().map(BasicIngredient::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(ingredientPrice);
    }

    private void task8SelectShampoosByIngredientsCount() {
        int count = 2;
        List<BasicShampoo> shampoos = this.shampooService.findShampooByIngredientsCount(count);
        shampoos.forEach(s -> System.out.printf("%s%n", s.getBrand()));
    }

    private void task7SelectShampoosByIngredients() {
        List<String> ingredientNames = new ArrayList<>();
        ingredientNames.add("Berry");
        ingredientNames.add("Mineral-Colagen");
        List<BasicIngredient> ingredients = this.ingredientService.findByNames(ingredientNames);
        List<BasicShampoo> shampoos = this.shampooService.findByIngredients(ingredients);
        for (BasicShampoo shampoo : shampoos) {
            System.out.printf("%s%n", shampoo.getBrand());
        }
    }

    private void task6CountShampoosByPrice() {
        List<BasicShampoo> shampoos = this.shampooService.findByPriceLessThan(BigDecimal.valueOf(8.50));
        System.out.println(shampoos.size());
    }

    private void task5SelectIngredientsByNames() {
        List<String> names = new ArrayList<>();
        names.add("Lavender");
        names.add("Herbs");
        names.add("Apple");
        List<BasicIngredient> ingredients = this.ingredientService.findByNames(names);
        ingredients.forEach(x -> System.out.printf("%s%n", x.getName()));
    }

    private void task4SelectIngredientsByName() {
        String letter = "M";
        List<BasicIngredient> ingredients = this.ingredientService.findByNameStartingWith(letter);
        ingredients.forEach(x -> System.out.printf("%s%n", x.getName()));
    }

    private void task3SelectShampoosByPrice() {
        List<BasicShampoo> shampoos = this.shampooService.findByPriceGreaterThanOrderByPriceDesc(BigDecimal.valueOf(5));
        shampoos.forEach(x -> System.out.printf("%s %s %s%n", x.getBrand(), x.getSize(), x.getPrice()));
    }

    private void task2SelectShampoosBySizeOrLabel() {
        Size size = Size.MEDIUM;
        BasicLabel label = this.labelService.findOne(10L);
        List<BasicShampoo> shampoos = this.shampooService.findBySizeOrLabelOrderByPriceAsc(size, label);

        for (BasicShampoo shampoo : shampoos) {
            System.out.printf("%s %s %s%n", shampoo.getBrand(), shampoo.getSize(), shampoo.getPrice());
        }
    }

    private void task1SelectShampooBySize() {
        Size size = Size.MEDIUM;

        List<BasicShampoo> shampoos = this.shampooService.selectShampoosBySize(size);

        for (BasicShampoo shampoo : shampoos) {
            System.out.printf("%s %s %s %s%n", shampoo.getBrand(), shampoo.getSize(), shampoo.getPrice(), shampoo.getLabel().getTitle());
        }
    }
}
