package application.services.api;


import java.util.List;

public interface SaleService<Sale, Long> extends Service<Sale, Long>{

    List<Object[]> salesWithAppliedDiscount();
}
