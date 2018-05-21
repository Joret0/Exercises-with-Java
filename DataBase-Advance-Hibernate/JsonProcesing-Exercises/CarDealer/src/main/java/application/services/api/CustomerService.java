package application.services.api;

import java.util.List;

public interface CustomerService<Customer, Long> extends Service<Customer, Long>{

    List<Customer> orderedCustomers();

    List<Customer> totalSalesByCustomer();
}
