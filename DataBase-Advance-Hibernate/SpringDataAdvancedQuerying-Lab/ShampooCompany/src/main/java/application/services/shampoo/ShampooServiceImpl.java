package application.services.shampoo;

import application.model.enums.Size;
import application.model.ingredients.BasicIngredient;
import application.model.labels.Label;
import application.model.shampoos.BasicShampoo;
import application.repositories.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Primary
public class ShampooServiceImpl implements ShampooService<BasicShampoo, Long>{
    private ShampooRepository shampooRepository;

    @Autowired
    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<BasicShampoo> selectShampoosBySize(Size size) {
        return this.shampooRepository.findBySize(size);
    }

    @Override
    public List<BasicShampoo> findBySizeOrLabelOrderByPriceAsc(Size size, Label label) {
        return this.shampooRepository.findBySizeOrLabelOrderByPriceAsc(size, label);
    }

    @Override
    public List<BasicShampoo> findByPriceGreaterThanOrderByPriceDesc(BigDecimal price) {
        return this.shampooRepository.findByPriceGreaterThanOrderByPriceDesc(price);
    }

    @Override
    public List<BasicShampoo> findByPriceLessThan(BigDecimal price) {
        return this.shampooRepository.findByPriceLessThan(price);
    }

    @Override
    public List<BasicShampoo> findByIngredients(List<BasicIngredient> ingredients) {
        return this.shampooRepository.findByIngredients(ingredients);
    }

    @Override
    public List<BasicShampoo> findShampooByIngredientsCount(int count) {
        return this.shampooRepository.findShampooByIngredientsCount(count);
    }

    @Override
    public BasicShampoo findBasicShampoosByBrand(String brand) {
        return this.shampooRepository.findBasicShampoosByBrand(brand);
    }
}
