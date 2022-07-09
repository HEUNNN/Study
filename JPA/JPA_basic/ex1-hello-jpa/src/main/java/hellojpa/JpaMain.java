package hellojpa;


import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin(); // database transaction 시작

        try {

            Member member = new Member();
            member.setUsername("hello");

            em.persist(member);

            em.flush();
            em.clear();

            Member findMember1 = em.getReference(Member.class, member.getId()); // proxy
            System.out.println("findMember1 is proxy: " + findMember1.getClass());

            // 준영속 상태
            em.detach(findMember1);

            String username = findMember1.getUsername();// proxy (강제) 호출 → 초기화
            System.out.println(username);

            // 프록시 확인
            boolean loaded = emf.getPersistenceUnitUtil().isLoaded(findMember1);

            // 프록시 강제 초기화
            Hibernate.initialize(findMember1);


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    private static void printMemberAndTeam(Member member) {

        String username = member.getUsername();
        String teamName = member.getTeam().getName();

        System.out.println("userName: " + username + ", teamName: " + teamName);

    }
}
