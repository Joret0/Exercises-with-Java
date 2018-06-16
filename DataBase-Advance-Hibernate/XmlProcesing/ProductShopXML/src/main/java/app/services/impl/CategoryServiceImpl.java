package app.services.impl;

import app.modules.Category;
import app.repositories.CategoryRepository;
import app.services.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService<Category, Long> {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Set<Object[]> categoriesByProductsCount() {
        return this.categoryRepository.categoriesByProductsCount();
    }

    @Override
    public Category findById(Long id) {
        return this.categoryRepository.findOne(id);
    }

    @Override
    public void remove(Category object) {
        this.categoryRepository.delete(object);
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public void save(Category object) {
        this.categoryRepository.save(object);
    }

    @Override
    public void saveList(List<Category> object) {
        this.categoryRepository.save(object);
    }
}
