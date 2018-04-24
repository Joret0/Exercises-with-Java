package application.services.category;

import application.models.Category;
import application.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class CategoryServiceImpl implements CategoryService<Category, Long>{
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
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
        return (List<Category>) this.categoryRepository.findAll();
    }

    @Override
    public void save(Category object) {
        this.categoryRepository.save(object);
    }
}
