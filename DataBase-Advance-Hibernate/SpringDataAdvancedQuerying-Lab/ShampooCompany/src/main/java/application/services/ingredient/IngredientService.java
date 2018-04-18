package application.services.ingredient;

import application.model.ingredients.Ingredient;

import java.util.List;

public interface IngredientService<E, K> {

    List<E> findByNameStartingWith(String letter);
    List<E> findByNames(List<String> names);
    void deleteByName(String name);
    void increaseIngredientsPrice();
    void updatePricesInGivenList(List<String> namesList);
}
