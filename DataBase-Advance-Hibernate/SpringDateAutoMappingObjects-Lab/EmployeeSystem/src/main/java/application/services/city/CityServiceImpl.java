package application.services.city;

import application.models.City;
import application.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class CityServiceImpl implements CityService<City, Long>{
    private CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City findById(Long id) {
        return this.cityRepository.findOne(id);
    }

    @Override
    public void remove(City object) {
        this.cityRepository.delete(object);
    }

    @Override
    public List<City> findAll() {
        return this.cityRepository.findAll();
    }

    @Override
    public void save(City object) {
        this.cityRepository.save(object);
    }
}
