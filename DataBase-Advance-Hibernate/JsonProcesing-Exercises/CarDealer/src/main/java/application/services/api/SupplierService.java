package application.services.api;

import java.util.List;

public interface SupplierService<Supplier, Long> extends Service<Supplier, Long>{
    List<Supplier> findAllSupplierByIsImporterFalse();
}
