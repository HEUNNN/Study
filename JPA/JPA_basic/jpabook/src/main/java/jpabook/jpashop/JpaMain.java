package jpabook.jpashop;

import jpabook.jpashop.domain.item.Book;

import javax.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

            Book book = new Book();
            book.setName("JPA");
            book.setPrice(10000);
            book.setAuthor("김영한");
            book.setIsbn("123123");
            book.setStockQuantity(10);

            em.persist(book);

            tx.commit();
        } catch (Exception e) {
            System.out.println(e);
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }
}
