package application.repositories;

import application.model.enums.Size;
import application.model.ingredients.BasicIngredient;
import application.model.ingredients.Ingredient;
import application.model.labels.Label;
import application.model.shampoos.BasicShampoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<BasicShampoo, Long>{

    List<BasicShampoo> findBySize(Size size);
    List<BasicShampoo> findBySizeOrLabelOrderByPriceAsc(Size size, Label label);
    List<BasicShampoo> findByPriceGreaterThanOrderByPriceDesc(BigDecimal price);
    List<BasicShampoo> findByPriceLessThan(BigDecimal price);
    List<BasicShampoo> findByIngredients(List<BasicIngredient> ingredients);
    @Query("select s from BasicShampoo as s where s.ingredients.size < :count")
    List<BasicShampoo> findShampooByIngredientsCount(@Param(value = "count") int count);
    BasicShampoo findBasicShampoosByBrand(String brand);
}
