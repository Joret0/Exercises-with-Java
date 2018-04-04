package application.services.resources;

import application.models.Resource;
import application.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class ResourceServiceImpl implements ResourceService<Resource, Long>{
    private ResourceRepository resourceRepository;

    @Autowired
    public ResourceServiceImpl(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @Override
    public Resource findByName(String name) {
        return this.resourceRepository.findByName(name);
    }

    @Override
    public List<Resource> findAllByCourseName(String name) {
        return this.resourceRepository.findAllByCourseName(name);
    }

    @Override
    public Resource findById(Long id) {
        return this.resourceRepository.findOne(id);
    }

    @Override
    public void remove(Resource object) {
        this.resourceRepository.delete(object);
    }

    @Override
    public List<Resource> findAll() {
        return this.resourceRepository.findAll();
    }

    @Override
    public void save(Resource object) {
        this.resourceRepository.save(object);
    }
}
