import domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");// persistence.xml 에 설정된 이름 사용
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction(); // transaction

        tx.begin();

        try {
            Member memberA = new Member();
            memberA.setName("Apple Lee");
            memberA.setCity("Seoul");

            Member memberB = new Member();
            memberB.setName("peach kim");
            memberB.setCity("Busan");

            em.persist(memberA);
            em.persist(memberB);

            Order orderA1 = new Order();
            orderA1.setMember(memberA);
            orderA1.setLocalDateTime(LocalDateTime.now());
            orderA1.setStatus(OrderStatus.ORDER);

            Order orderA2 = new Order();
            orderA2.setMember(memberA);
            orderA2.setLocalDateTime(LocalDateTime.now());
            orderA2.setStatus(OrderStatus.ORDER);

            Order orderB = new Order();
            orderB.setMember(memberB);
            orderB.setLocalDateTime(LocalDateTime.now());
            orderB.setStatus(OrderStatus.ORDER);

            em.persist(orderA1);
            em.persist(orderA2);
            em.persist(orderB);

            Item book = new Item();
            book.setName("JPA book");
            book.setPrice(10000);
            book.setStockQuantity(10);

            Item fruit = new Item();
            fruit.setName("water melon");
            fruit.setPrice(5000);
            fruit.setStockQuantity(1);

            Item bag = new Item();
            bag.setName("shoulder bag");
            bag.setPrice(50000);
            bag.setStockQuantity(2);

            em.persist(book);
            em.persist(fruit);
            em.persist(bag);

            OrderItem orderItem1 = new OrderItem();
            orderItem1.setOrder(orderA1);
            orderItem1.setItem(book);
            orderItem1.setOrderPrice(10000);
            orderItem1.setCount(2);


            OrderItem orderItem2 = new OrderItem();
            orderItem2.setOrder(orderA2);
            orderItem2.setItem(fruit);
            orderItem2.setOrderPrice(5000);
            orderItem2.setCount(1);


            OrderItem orderItem3 = new OrderItem();
            orderItem3.setOrder(orderB);
            orderItem3.setItem(bag);
            orderItem3.setOrderPrice(50000);
            orderItem3.setCount(1);


            em.persist(orderItem1);
            em.persist(orderItem2);
            em.persist(orderItem3);


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
