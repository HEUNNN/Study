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

            Team team = new Team();
            team.setName("team1");
            Member member = new Member();
            member.setUsername("hello");
            member.setTeam(team);

            em.persist(team);
            em.persist(member);

            em.flush();
            em.clear();

            Member findMember1 = em.find(Member.class, member.getId());
            System.out.println("find member class = " + findMember1.getClass());

            Team findTeam = findMember1.getTeam();
            System.out.println("team class = " + findTeam.getClass());

            // proxy로 가져온 team을 초기화 → 쿼리가 생긴다.
            System.out.println("team 초기화 start");
            String teamName = findTeam.getName();
            System.out.println(findTeam.getClass());

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
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
