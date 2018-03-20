import entities.Customer;
import entities.Product;
import entities.Sale;
import entities.StoreLocation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("salesdb");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Product product = new Product();
        product.setName("Samsung Galaxy 8 Edge");
        product.setPrice(new BigDecimal(990));

        Customer customer = new Customer();
        customer.setName("Georgi");
        customer.setCreditCardNumber("0123456789");
        customer.setEmail("georgi_stalev@abv.bg");


        StoreLocation location = new StoreLocation();
        location.setLocationName("Sofia Bulgaria");

        Sale sale = new Sale();
        sale.setCustomer(customer);
        sale.setProduct(product);
        sale.setStoreLocation(location);

        Set<Sale> sales = new HashSet<Sale>() {{
           add(sale);
        }};
        customer.setCustomerSales(sales);

        em.persist(location);
        em.persist(product);
        em.persist(customer);
        em.persist(sale);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
