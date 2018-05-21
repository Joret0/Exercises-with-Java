package application.services.impl;

import application.model.Sale;
import application.repositories.SaleRepository;
import application.services.api.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService<Sale, Long>{
    private SaleRepository saleRepository;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public Sale findById(Long id) {
        return this.saleRepository.findOne(id);
    }

    @Override
    public void remove(Sale object) {
        this.saleRepository.delete(object);
    }

    @Override
    public List<Sale> findAll() {
        return this.saleRepository.findAll();
    }

    @Override
    public void save(Sale object) {
        this.saleRepository.save(object);
    }

    @Override
    public void saveList(List<Sale> objects) {
        this.saleRepository.save(objects);
    }

    @Override
    public List<Object[]> salesWithAppliedDiscount() {
        return this.saleRepository.salesWithAppliedDiscount();
    }
}
