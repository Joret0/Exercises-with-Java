package application.services.impl;

import application.model.Customer;
import application.repositories.CustomerRepository;
import application.services.api.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService<Customer, Long>{
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer findById(Long id) {
        return this.customerRepository.findOne(id);
    }

    @Override
    public void remove(Customer object) {
        this.customerRepository.delete(object);
    }

    @Override
    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public void save(Customer object) {
        this.customerRepository.save(object);
    }

    @Override
    public void saveList(List<Customer> objects) {
        this.customerRepository.save(objects);
    }

    @Override
    public List<Customer> orderedCustomers() {
        return this.customerRepository.orderedCustomers();
    }

    @Override
    public List<Customer> totalSalesByCustomer() {
        return this.customerRepository.totalSalesByCustomer();
    }
}