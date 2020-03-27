package inheritJoined;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Demo {
    public static void main(String[] args) {
        G a=new G();
        a.setId(1);
        a.setName("A");

        H b=new H();
        b.setId(2);
        b.setName("B");
        b.setValueOne("b");

        I c=new I();
        c.setId(3);
        c.setName("C");
        c.setValueTwo("c");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sampleapp");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(a);
        em.persist(b);
        em.persist(c);

        tx.commit();
        em.close();
        emf.close();
    }
}