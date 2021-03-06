package inherit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Demo {
    public static void main(String[] args) {
        A a=new A();
        a.setId(1);
        a.setName("A");

        B b=new B();
        b.setId(2);
        b.setName("B");
        b.setValueOne("b");

        C c=new C();
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