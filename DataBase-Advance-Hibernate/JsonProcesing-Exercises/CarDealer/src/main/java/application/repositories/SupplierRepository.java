package application.repositories;

import application.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Long>{
    List<Supplier> findAllSupplierByIsImporterFalse();
}
