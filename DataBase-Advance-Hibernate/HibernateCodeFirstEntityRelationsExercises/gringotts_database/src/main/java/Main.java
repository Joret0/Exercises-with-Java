import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gringottsdatabase");
        EntityManager em = emf.createEntityManager();

        WizardDeposit dumbledore = new WizardDeposit();
        dumbledore.setFirstName("Albus");
        dumbledore.setLastName("Dumbledore");
        dumbledore.setAge(150);
        dumbledore.setMagicLandCreator("Antoich Peverell");
        dumbledore.setMagicLandSize(15);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2017, 10, 21);
        Date depositStart = calendar.getTime();
        dumbledore.setDepositStartDate(depositStart);
        calendar.set(2021, 10, 21);
        Date depositEnd = calendar.getTime();
        dumbledore.setDepositExpireDate(depositEnd);
        dumbledore.setDepositAmount(3333.66);
        dumbledore.setDepositCharge(3.5);
        dumbledore.setDepositExpired(false);

        em.getTransaction().begin();
        em.persist(dumbledore);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
