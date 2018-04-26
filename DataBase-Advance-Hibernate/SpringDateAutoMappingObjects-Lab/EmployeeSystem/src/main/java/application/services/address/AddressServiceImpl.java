package application.services.address;

import application.models.Address;
import application.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class AddressServiceImpl implements AddressService<Address, Long>{
    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address findById(Long id) {
        return this.addressRepository.findOne(id);
    }

    @Override
    public void remove(Address object) {
        this.addressRepository.delete(object);
    }

    @Override
    public List<Address> findAll() {
        return this.addressRepository.findAll();
    }

    @Override
    public void save(Address object) {
        this.addressRepository.save(object);
    }
}
