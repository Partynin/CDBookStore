package ru.partynin.chapter04;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        // Create an instance of book
        Book book = new Book("H2G2", "The Hitchhiker's Guide to the Galaxy", 12.5f,
                "1-84023-742-2", 354, false);

        // Obtains an entity manager and a transaction
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "chapter04PU");
        EntityManager em = emf.createEntityManager();

        // Persists the book to the database
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(book);
        tx.commit();

        // Executes the named query
        book = em.createNamedQuery("findBookH2G2", Book.class).getSingleResult();

        System.out.println("####### " + book.getDescription());

        // Closes the entity manager and the factory
        em.close();
        emf.close();
    }
}
