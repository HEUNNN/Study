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

/*

            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            em.persist(member);

*/

/*            TypedQuery<Member> query1 = em.createQuery("select m from Member m", Member.class);
            // TypeQuery: 반환 타입이 명확할 때 사용
            Query query2 = em.createQuery("select m.username, m.age from Member m");
            // Query: 반환 타입이 명확하지 않을 때 사용

            // 결과 조회 API
            List<Member> resultList1 = query1.getResultList(); // 결과가 하나 이상일 때 리스트를 반환한다. 결과가 없으면 empty 리스트 반환한다.
            Member singleResult2 = query1.getSingleResult(); // 결과가 정확히 하나일 때 단일 객체를 반환한다.

            // 파라미터 바인딩
            TypedQuery<Member> query3 = em.createQuery("select m from Member m where m.username = :username", Member.class);
            query3.setParameter("username", "member1");
            Member singleResult3 = query3.getSingleResult();*/

/*

            em.flush();
            em.clear();

            List<Member> resultList1 = em.createQuery("select m from Member m", Member.class) // 엔티티 프로젝션(조회)이니까 조회되는 List<Member>의 Member도 엔티티이다.
                    .getResultList();
            // List<Member>도 영속성 컨텍스트에 의해 관리가 될까?
            Member member1 = resultList1.get(0);
            member1.setAge(20); // 변화가 있으면 영속성 컨텍스트에 의해 관리가 된다는 뜻이다.

            // 임베디드 타입 프로젝션
            List<Address> resultList2 = em.createQuery("select o.address from Order o", Address.class).getResultList();

            // 스칼라 타입 프로젝션 + DISTINCT
            List resultList3 = em.createQuery("select distinct m.username, m.age from Member m").getResultList();

            // 쿼리 타입으로 여러 값 조회
            Object o = resultList3.get(0);
            Object[] result = (Object[]) o;
            System.out.println("username = " + result[0]);
            System.out.println("age = " + result[1]);

            // Object[] 타입으로 여러 값 조회
            List<Object[]> resultList4 = em.createQuery("select distinct m.username, m.age from Member m").getResultList();
            Object[] objects = resultList4.get(0);
            System.out.println("username = " + objects[0]);
            System.out.println("age = " + objects[1]);

            // new 명령어로 여러 값 조회
            List<MemberDTO> resultList5 = em.createQuery("select new jpql.MemberDTO(m.username, m.age) from Member m", MemberDTO.class)
                    .getResultList();
            MemberDTO memberDTO = resultList5.get(0);
            System.out.println("memberDTO = " + memberDTO.getUsername() + ", " + memberDTO.getAge());

*/
            // 페이징 API
/*

            for (int i = 0; i < 100; i++) {
                Member newMember = new Member();
                newMember.setUsername("member" + (i + 1));
                newMember.setAge(i + 1);
                em.persist(newMember);

            }

            em.flush();
            em.clear();

            String jpql = "select m from Member m order by m.age desc";
            List<Member> resultList6 = em.createQuery(jpql, Member.class)
                    .setFirstResult(1)
                    .setMaxResults(10)
                    .getResultList();

            System.out.println("result.size = " + resultList6.size());
            for (Member m : resultList6) {
                System.out.println("member = " + m);
            }
*/
            // Join
            Team teamA = new Team();
            teamA.setName("teamA");

            Team teamB = new Team();
            teamB.setName("teamB");

            em.persist(teamA);
            em.persist(teamB);

            Member member1 = new Member();
            member1.setUsername("member1");
            member1.setAge(10);
            member1.changeTeam(teamA);

            Member member2 = new Member();
            member2.setUsername("teamB");
            member2.setAge(20);
            member2.changeTeam(teamB);

            em.persist(member1);
            em.persist(member2);

            em.flush();
            em.clear();

            String innerQuery1 = "select m from Member m inner join m.team t"; // inner 생략 가능
            String innerQuery2 = "select m from Member m inner join m.team t where t.name = :teamName";
            String outerQuery1 = "select m from Member m left outer join m.team t"; // outer 생략 가능
            String setaQuery1 = "select m from Member m, Team t where m.username = t.name";

            // ON 사용
            // ON - 조인 대상 필터링
            String onQuery1 = "select m from Member m join m.team t on t.name = 'teamA'";
            String onQuery2 = "select m from Member m left join m.team t on t.name = 'teamA'";
            
            // ON - 연관관계 없는 엔티티 외부 조인
            String onQuery3 = "select m, t from Member m left join Team t on m.username = t.name"; // 특정 멤버의 이름과, 특정 팀의 이름이 같은지 확인한다.

            List<Member> resultList7 = em.createQuery(onQuery2, Member.class)
                    .getResultList();

            List<Member> resultList8 = em.createQuery(innerQuery2, Member.class)
                    .setParameter("teamName", "teamB")
                    .getResultList();

            for (Member m : resultList7) {
                System.out.println(m);
            }

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
