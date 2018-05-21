package application.services.impl;

import application.entities.Product;
import application.repositories.ProductRepository;
import application.services.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
@Primary
public class ProductServiceImpl implements ProductService<Product, Long>{

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findById(Long id) {
        return this.productRepository.findOne(id);
    }

    @Override
    public void remove(Product object) {
        this.productRepository.delete(object);
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public void save(Product object) {
        this.productRepository.save(object);
    }

    @Override
    public void saveList(List<Product> objects) {
        this.productRepository.save(objects);
    }

    @Override
    public Set<Product> findProductByBuyerIsNullAndPriceBetweenOrderByPrice(BigDecimal min, BigDecimal max) {
        return this.productRepository.findProductByBuyerIsNullAndPriceBetweenOrderByPrice(min, max);
    }
}
