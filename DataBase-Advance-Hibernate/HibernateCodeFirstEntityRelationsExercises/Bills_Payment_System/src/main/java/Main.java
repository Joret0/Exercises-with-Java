import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bills_payment_system");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        User user = new User("Georgi", "Stalev", "0123456789", "georgi_stalev@abv.bg");
        em.persist(user);

        User user2 = new User("Ivan", "Stalev", "0123456789", "g.stalev@abv.bg");
        em.persist(user2);

        BillingDetails creditCard = new CreditCard("CardTypeVip", "November", 2019);
        creditCard.setNumber(11);
        creditCard.setOwner(user);
        em.persist(creditCard);

        BillingDetails billingDetails = new BankAccount("Raifaisen Bank", "swiftCode");
        billingDetails.setOwner(user2);
        billingDetails.setNumber(9);
        em.persist(billingDetails);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
