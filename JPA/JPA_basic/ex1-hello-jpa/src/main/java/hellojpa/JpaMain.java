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

            Member newMember = new Member();
            newMember.setId(10L);
            newMember.setName("apple");
            // newMember는 비영속 상태

            System.out.println("===Before===");
            em.persist(newMember);
            System.out.println("===After===");
            // newMember는 영속 상태 → 엔티티 매니저에 들어 있는 영속성 컨텍스트라는 곳에서 newMember를 이제부터 관리한다는 뜻이다.
            // 이때 DB에 저장되는 것이 아니다. DB에 저장되는지(쿼리가 날아가는지) 확인하기 위해 Before, After 출력


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
