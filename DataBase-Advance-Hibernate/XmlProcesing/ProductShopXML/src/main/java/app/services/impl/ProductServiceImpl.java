package app.services.impl;

import app.modules.Product;
import app.repositories.ProductRepository;
import app.services.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService<Product, Long> {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Set<Object[]> productsInRange() {
        return this.productRepository.productsInRange();
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
    public void saveList(List<Product> object) {
        this.productRepository.save(object);
    }
}
