package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin(); // database transaction 시작

        try {

/*            Member member1 = new Member();
            member1.setUsername("member1");
            member1.setHomeAddress(new Address("busan", "gil", "12355"));

            Member member2 = new Member();
            member2.setUsername("member2");
            member2.setHomeAddress(new Address("Ulsan", "ig", "1231243"));

            // Collection
            member1.getFavoriteFoods().add("치킨");
            member1.getFavoriteFoods().add("피자");
            member1.getFavoriteFoods().add("삼겹살");

            member1.getAddressHistory().add(new AddressEntity("부산", "진구", "12998"));
            member1.getAddressHistory().add(new AddressEntity("울산", "울주군", "129434"));
            member1.getAddressHistory().add(new AddressEntity("제주도", "뿡", "12334"));

            em.persist(member1);
            em.persist(member2);

            em.flush();
            em.clear();

            // 값 타입 컬렉션 조회
            System.out.println("====== START ======");
            Member findMember1 = em.find(Member.class, member1.getId());

            // 값 타입 수정
//            findMember1.getHomeAddress().setCity("seoul"); // Side Effect 발생할 수 있기 때문에 값 타입은 이렇게 수정하면 안된다. (getter, setter를 없애거나 private으로 막아둬야 한다.)
            findMember1.setHomeAddress(new Address("Seoul", "gil", "12355")); // 새로운 Address 인스터스를 넣어줘서 수정해야한다.

            // 값 타입 컬렉션 수정 → 갈아 끼워야 한다.
            findMember1.getFavoriteFoods().remove("치킨");
            findMember1.getFavoriteFoods().add("사탕");

            List<AddressEntity> addressHistory = findMember1.getAddressHistory();

            for (AddressEntity addressEntity : addressHistory) {
                addressEntity.getAddress().setCity("ssss"); // 이렇게 밖에 못하나?
            }*/

            Member member = new Member();
            member.setUsername("kim");

            em.persist(member);

            // JPQL

/*            String jpql = "select m from Member m where m.username like '%kim%'";
            List<Member> result = em.createQuery(jpql, Member.class).getResultList();*/

            // Criteria → 쿼리를 코드로 작성
            // Criteria 사용 준비
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Member> query = cb.createQuery(Member.class);

            // 루트 클래스 (조회를 시작할 클래스)
            Root<Member> m = query.from(Member.class);

            // 쿼리 생성
            CriteriaQuery<Member> cq = query.select(m).where(cb.equal(m.get("username"), "kim"));
            List<Member> result = em.createQuery(cq).getResultList();

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
