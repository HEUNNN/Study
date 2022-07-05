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

            // 새로 EntityManager가 생성되었다.
            // 이미 저장되어 있는 member 정보를 총 2회 조회한다.
            Member findMember1 = em.find(Member.class, 101L); // 1회차 조회시에는 쿼리를 사용하여 DB에서 id가 101인 데이터를 찾아온다. 그 후 1차 캐시에 데이터 저장한다.
            Member findMember2 = em.find(Member.class, 101L); // 2회차 조회시에는 쿼리를 사용하지 않고, 1차 캐시에서 바로 데이터를 찾아온다.

            System.out.println(findMember1 == findMember2); // 동일성 비교

            findMember1.setName("appleeee!"); // 엔티티 수정 , DirtyCheck 변경 감지 기능으로 엔티티 수정이 쉽게 된다. 

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
