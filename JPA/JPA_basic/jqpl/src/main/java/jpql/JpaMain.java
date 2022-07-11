package jpql;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            em.persist(member);

            TypedQuery<Member> query1 = em.createQuery("select m from Member m", Member.class);
            // TypeQuery: 반환 타입이 명확할 때 사용
            Query query2 = em.createQuery("select m.username, m.age from Member m");
            // Query: 반환 타입이 명확하지 않을 때 사용

            // 결과 조회 API
            List<Member> resultList1 = query1.getResultList(); // 결과가 하나 이상일 때 리스트를 반환한다. 결과가 없으면 empty 리스트 반환한다.
            Member singleResult2 = query1.getSingleResult(); // 결과가 정확히 하나일 때 단일 객체를 반환한다.

            // 파라미터 바인딩
            TypedQuery<Member> query3 = em.createQuery("select m from Member m where m.username = :username", Member.class);
            query3.setParameter("username", "member1");
            Member singleResult3 = query3.getSingleResult();

            System.out.println("single Result = " + singleResult3.getUsername());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }
}
