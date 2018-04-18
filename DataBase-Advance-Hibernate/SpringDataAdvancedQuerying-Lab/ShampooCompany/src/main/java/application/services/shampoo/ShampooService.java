package application.services.shampoo;

import application.model.enums.Size;
import application.model.ingredients.BasicIngredient;
import application.model.labels.Label;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooService<E, K> {
    List<E> selectShampoosBySize(Size size);
    List<E> findBySizeOrLabelOrderByPriceAsc(Size size, Label label);
    List<E> findByPriceGreaterThanOrderByPriceDesc(BigDecimal price);
    List<E> findByPriceLessThan(BigDecimal price);
    List<E> findByIngredients(List<BasicIngredient> ingredients);
    List<E> findShampooByIngredientsCount(int count);
    E findBasicShampoosByBrand(String brand);
}
