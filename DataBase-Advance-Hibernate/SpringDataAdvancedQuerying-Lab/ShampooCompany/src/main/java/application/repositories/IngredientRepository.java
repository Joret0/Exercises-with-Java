package application.repositories;

import application.model.ingredients.BasicIngredient;
import application.model.ingredients.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<BasicIngredient, Long>{
    List<BasicIngredient> findByNameStartingWith(String letter);
    @Query("select i from BasicIngredient i where i.name in :names order by i.name asc")
    List<BasicIngredient> findByNames(@Param(value = "names") List<String> names);
    @Modifying
    void deleteByName(String name);
    @Modifying
    @Query("update BasicIngredient i set i.price = i.price * 1.10")
    void increaseIngredientsPrice();
    @Modifying
    @Query("update BasicIngredient i set i.price = i.price * 1.10 where i.name in :names")
    void updatePricesInGivenList(@Param(value = "names") List<String> namesList);
}
