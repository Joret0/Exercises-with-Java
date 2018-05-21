package application.services.impl;

import application.model.Part;
import application.repositories.PartRepository;
import application.services.api.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartServiceImpl implements PartService<Part, Long>{

    private PartRepository partRepository;

    @Autowired
    public PartServiceImpl(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Override
    public Part findById(Long id) {
        return this.partRepository.findOne(id);
    }

    @Override
    public void remove(Part object) {
        this.partRepository.delete(object);
    }

    @Override
    public List<Part> findAll() {
        return this.partRepository.findAll();
    }

    @Override
    public void save(Part object) {
        this.partRepository.save(object);
    }

    @Override
    public void saveList(List<Part> objects) {
        this.partRepository.save(objects);
    }
}
