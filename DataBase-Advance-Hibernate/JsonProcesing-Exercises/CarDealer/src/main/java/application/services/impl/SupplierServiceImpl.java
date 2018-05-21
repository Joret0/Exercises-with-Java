package application.services.impl;

import application.model.Supplier;
import application.repositories.SupplierRepository;
import application.services.api.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService<Supplier, Long>{
    private SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public Supplier findById(Long id) {
        return this.supplierRepository.findOne(id);
    }

    @Override
    public void remove(Supplier object) {
        this.supplierRepository.delete(object);
    }

    @Override
    public List<Supplier> findAll() {
        return this.supplierRepository.findAll();
    }

    @Override
    public void save(Supplier object) {
        this.supplierRepository.save(object);
    }

    @Override
    public void saveList(List<Supplier> objects) {
        this.supplierRepository.save(objects);
    }

    @Override
    public List<Supplier> findAllSupplierByIsImporterFalse() {
        return this.supplierRepository.findAllSupplierByIsImporterFalse();
    }
}
