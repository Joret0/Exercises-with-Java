package application.services.town;

import application.models.Town;
import application.repositories.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class TownServiceImpl implements TownService<Town, Long>{

    private TownRepository townRepository;

    @Autowired
    public TownServiceImpl(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    @Override
    public Town findById(Long id) {
        return this.townRepository.findOne(id);
    }

    @Override
    public void remove(Town object) {
        this.townRepository.delete(object);
    }

    @Override
    public List<Town> findAll() {
        return this.townRepository.findAll();
    }

    @Override
    public void save(Town object) {
        this.townRepository.save(object);
    }
}
