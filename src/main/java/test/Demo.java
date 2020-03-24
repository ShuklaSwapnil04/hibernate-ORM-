package test;

import javax.persistence.*;
import javax.persistence.EntityTransaction;
import java.util.List;

public class Demo {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sampleapp");

    static void saveData(Student s) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(s);

        tx.commit();
        em.close();
        emf.close();
    }

    static Student searchData(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Student s = em.find(Student.class, id);

        tx.commit();
        em.close();
        emf.close();

        return s;
    }

    static void updateData(int id, String name) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Student s = em.find(Student.class, id);
        s.setName(name);
        tx.commit();
        em.close();
        emf.close();
    }

    static void removeData(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Student s = em.find(Student.class, id);
        em.remove(s);
        tx.commit();
        em.close();
        emf.close();
    }

    static List<Student> getAllData() {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        ;

        Query q = em.createQuery("select p from Student p where p.id > 105");
        List<Student> list = q.getResultList();

        tx.commit();
        em.close();
        emf.close();

        return list;
    }

    public static void main(String[] args) {

        //Student s = searchData(101);
      //  System.out.println(s);
        Student s= new Student();
        s.setId(101);
        s.setName("ramu");
        saveData(s);
       //] updateData(103, "shamu");
      //  removeData(103);

      /*  List<Student> list = getAllData();
        for (Student s : list) {
            System.out.println(s);
        }*/
    }
}