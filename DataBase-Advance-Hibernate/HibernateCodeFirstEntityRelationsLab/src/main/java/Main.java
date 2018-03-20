import models.ingredients.AmmoniumChloride;
import models.ingredients.BasicIngredient;
import models.ingredients.Mint;
import models.ingredients.Nettle;
import models.labels.BasicLabel;
import models.products.BasicShampoo;
import models.products.FreshNuke;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        BasicIngredient am = new AmmoniumChloride();
        em.persist(am);
        BasicIngredient mint = new Mint();
        em.persist(mint);
        BasicIngredient nettle = new Nettle();
        em.persist(nettle);

        BasicLabel label = new BasicLabel("Fresh Nuke Shampoo", "Contains mint and nettle");
        em.persist(label);

        BasicShampoo shampoo = new FreshNuke(label);

        shampoo.getIngredients().add(mint);
        shampoo.getIngredients().add(nettle);
        shampoo.getIngredients().add(am);

        em.persist(shampoo);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
