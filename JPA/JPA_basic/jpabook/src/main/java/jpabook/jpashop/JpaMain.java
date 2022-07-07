package jpabook.jpashop;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

            // 양방향 매핑시 연관관계의 주인에 값을 입력해야한다.
            // 주문 해보기
            Order order = new Order();
            order.addOrderItem(new OrderItem());
            /*
             * 주문 객체를 만들어서 orderItem 들을 넣을 수 있다.
             */

//            em.persist(order);

            // 양방향으로 연관관계 매핑이 안되어 있을 때  OrderItem에서 order 다루기
            // 주인은 OrderItem의 order 필드이다.
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order); // orderItem에 order를 넣어야한다. + order도 persist 되어 있어야 한다. order에 oerderItems에 orderItem을 넣는 것이 아니다.
            // 단방향 매핑으로도 충분하다.

            em.persist(orderItem);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }
}
