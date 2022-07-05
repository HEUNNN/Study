package hellojpa;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin(); // database transaction 시작

        try {
            // 이미 저장되어 있는 id: 1, name: HelloA 인 member 데이터를 수정하기
            Member findMember1 = em.find(Member.class, 1L);
//            Member findMember2 = em.find(Member.class, 3L); // id가 1L인 데이터 찾기/**/

            findMember1.setName("lee");
            // 수정 후에 em.persist() 안해도 된다. → Java Collection 처럼 사용할 수 있도록 JPA가 기능하기 때문이다.

            // 삭제
            // em.remove(findMember2);

            // JPQL로 전체 회원 검색
            List<Member> memberList = em.createQuery("select m from Member as m", Member.class)
                    .getResultList(); // JPA 는 테이블 입장

            for (Member member : memberList) {
                System.out.println("id: " + member.getId() + ", name: " + member.getName());
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
