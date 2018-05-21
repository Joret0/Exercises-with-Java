package application.services.impl;

import application.model.Car;
import application.repositories.CarRepository;
import application.services.api.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService<Car, Long>{

    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car findById(Long id) {
        return this.carRepository.findOne(id);
    }

    @Override
    public void remove(Car object) {
        this.carRepository.delete(object);
    }

    @Override
    public List<Car> findAll() {
        return this.carRepository.findAll();
    }

    @Override
    public void save(Car object) {
        this.carRepository.save(object);
    }

    @Override
    public void saveList(List<Car> objects) {
        this.carRepository.save(objects);
    }

    @Override
    public List<Car> findAllToyotaCars() {
        return this.carRepository.findAllToyotaCars();
    }
}
