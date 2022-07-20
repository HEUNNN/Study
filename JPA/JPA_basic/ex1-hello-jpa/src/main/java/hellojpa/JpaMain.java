package hellojpa;

import javax.persistence.*;
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

            Member member1 = new Member();
            member1.setUsername("member1");
            member1.setAge(12);
            member1.setHomeAddress(new Address("Busan", "Sasang", "12355"));

            Member member2 = new Member();
            member2.setUsername("member2");
            member2.setAge(23);
            member2.setHomeAddress(new Address("Ulsan", "Ulju", "1231243"));

            // Collection
            member1.getFavoriteFoods().add("치킨");
            member1.getFavoriteFoods().add("피자");
            member1.getFavoriteFoods().add("삼겹살");

            member1.getAddressHistory().add(new AddressEntity("부산", "진구", "12998"));
            member1.getAddressHistory().add(new AddressEntity("울산", "삼산", "129434"));
            member1.getAddressHistory().add(new AddressEntity("제주도", "성산", "12334"));

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

/*            for (AddressEntity addressEntity : addressHistory) {
                if (addressEntity.getId() == 2) {
                    String street = addressEntity.getAddress().getStreet();
                    String zipcode = addressEntity.getAddress().getZipcode();
                    addressEntity.setAddress(new Address("sss", street, zipcode));
                }
            }*/

            addressHistory.removeIf(addressEntity -> addressEntity.getId() == 2);
            addressHistory.add(new AddressEntity("aa", "bb", "xx"));

/*            Member member = new Member();
            member.setUsername("kim");

            em.persist(member);*/

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

            // 엔티티 직접 사용
/*            System.out.println("========================");
            List<Long> resultList = em.createQuery("select count(m.id) from Member m", Long.class).getResultList();
            for (Long long1 : resultList) {
                System.out.println(long1);
            }
            System.out.println("========================");
            List<Long> resultList1 = em.createQuery("select count(m) from Member m", Long.class).getResultList();
            for (Long long2 : resultList1) {
                System.out.println(long2); 
            }
            System.out.println("========================");*/

            // 벌크 연산 - 모든 멤버의 나이를 100살로 바꾸기
            System.out.println("========================");
            String bulkQuery1 = "update Member m set m.age = 20";
            String bulkQuery2 = "update Member m set m.age = 20 where m.age < 20";

            // Flush 자동 호출
            // Flush는 commit을 하거나, 쿼리가 나갈 때 flush 된다.
            int resultCnt = em.createQuery(bulkQuery1).executeUpdate(); // 영향을 받은 count

            // 벌크 연산을 하였지만, 이전에 영속성 컨텍스트에 존재하던 member1의 나이는 변하지 않았다.
            System.out.println("member1 age: " + member1.getAge()); // 12
            // 벌크 연산을 하면 flush가 된다. 그러나 clear는 안되었기 때문에 영속성 컨텍스트가 비워진 것은 아니다.
            // clear를 하고 member1.getAge()를 하는게 아니라 member1을 DB에서 find해와서 영속성 컨텍스트에 두면서 조회해야한다.
            em.clear();
            Member findMember = em.find(Member.class, member1.getId());
            System.out.println("find member1 age: " + findMember.getAge()); // 20

            System.out.println(resultCnt);
            System.out.println("========================");


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
