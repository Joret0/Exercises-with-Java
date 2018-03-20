import entities.Diagnose;
import entities.Medicament;
import entities.Patient;
import entities.Visitation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hospitaldb");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Visitation visitation = new Visitation();
        visitation.setDate(LocalDate.now());
        visitation.setComment("First visit for this month.");
        em.persist(visitation);

        Visitation visitation2 = new Visitation();
        visitation2.setDate(LocalDate.now());
        visitation2.setComment("Second visit for this month.");
        em.persist(visitation2);

        Medicament medicament = new Medicament();
        medicament.setName("galviscone");
        em.persist(medicament);

        Medicament medicament2 = new Medicament();
        medicament2.setName("Lansoprazole Capsules");
        em.persist(medicament2);

        Diagnose diagnose = new Diagnose();
        diagnose.setName("stomach acids");
        diagnose.setComments("Some comment");
        em.persist(diagnose);

        Diagnose diagnose2 = new Diagnose();
        diagnose2.setName("hearth burn");
        diagnose2.setComments("Some comment");
        em.persist(diagnose2);

        Set<Visitation> visitations = new HashSet<>();
        visitations.add(visitation);
        visitations.add(visitation2);

        Set<Diagnose> diagnoses = new HashSet<>();
        diagnoses.add(diagnose);
        diagnoses.add(diagnose2);

        Set<Medicament> medicaments = new HashSet<>();
        medicaments.add(medicament);
        medicaments.add(medicament2);

        Patient patient = new Patient("Georgi", "Stalev", "Sofia", "georgi_stalev@yahoo.com",
                LocalDate.of(1995, 02, 02), new byte[10], true,
                visitations, diagnoses, medicaments);

        em.persist(patient);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
