package application.services.ingredient;

import application.model.ingredients.BasicIngredient;
import application.model.ingredients.Ingredient;
import application.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class IngredientServiceImpl implements IngredientService<BasicIngredient, Long>{
    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<BasicIngredient> findByNameStartingWith(String letter) {
        return this.ingredientRepository.findByNameStartingWith(letter);
    }

    @Override
    public List<BasicIngredient> findByNames(List<String> names) {
        return this.ingredientRepository.findByNames(names);
    }

    @Override
    public void deleteByName(String name) {
        this.ingredientRepository.deleteByName(name);
    }

    @Override
    public void increaseIngredientsPrice() {
        this.ingredientRepository.increaseIngredientsPrice();
    }

    @Override
    public void updatePricesInGivenList(List<String> namesList) {
        this.ingredientRepository.updatePricesInGivenList(namesList);
    }
}
