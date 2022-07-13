package jpql;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Collection;
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
/*
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
*/
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Team team2 = new Team();
            team.setName("teamB");
            em.persist(team2);

            Member member1 = new Member();
            member1.setUsername("teamA");
            member1.setAge(10);
            member1.setTeam(team);
            member1.setType(MemberType.ADMIN);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("member2");
            member2.setAge(20);
            /*member2.setTeam(team2);*/
            member2.setType(MemberType.USER);
            em.persist(member2);


            Member member3 = new Member();
            member3.setUsername("member3");
            member3.setAge(70);
            member3.setTeam(team);
            member3.setType(MemberType.USER);
            em.persist(member3);

            Member member4 = new Member();
            member4.setUsername(" banana ");
            member4.setAge(4);
            member4.setTeam(team2);
            member4.setType(MemberType.USER);
            em.persist(member4);

            em.flush();
            em.clear();


            // JPQL 타입 표현
/*
            String q = "select m.username, 'HELLO', TRUE  from Member m";
            String q2 = "select m.username, 'HELLO', TRUE  from Member m " +
                    "where m.type = :userType";
            System.out.println("===================================");
            List<Object[]> resultList8 = em.createQuery(q2)
                    .setParameter("userType", MemberType.ADMIN)
                    .getResultList();
            System.out.println("===================================");

            for (Object[] o : resultList8) {
                System.out.println("objects = " + o[0]);
                System.out.println("objects = " + o[1]);
                System.out.println("objects = " + o[2]);
            }*/

            // CASE
            // 기본 CASE 식
/*            String caseQ1 =
                    "select " +
                    "        case when m.age <= 10 then '학생요금' " +
                    "             when m.age >= 60 then '경로요금' " +
                    "             else '일반요금' " +
                    "        end " +
                    "from Member m";

            // COALESCE: 하나씩 조회해서 null이 아니면 반환한다.
            String coaleseceQ1 = "select coalesce(m.username, '이름 없는 회원') from Member m";

            // NULLIF: 두 값이 같으면 null 반환, 다르면 첫번째 값 반환
            // 사용자의 이름이 'teamA'이면 null을 반환하고 나머지는 본인의 이름을 반환한다.
            String nullifQ1 = "select NULLIF(m.username, 'teamA') from Member m";
            List<String> resultList9 = em.createQuery(nullifQ1, String.class)
                    .getResultList();


            for (String s : resultList9) {
                System.out.println("s = " + s);
            }*/
            // JPQL 기본 함수

/*            String concatQ = "select concat('a', 'b') from Member m";
            String substringQ = "select substring(m.username, 2, 3) from Member m"; // 2번째 부터 3개를 잘라내라, teamA → eam
            String trimQ = "select trim(m.username) from Member m"; // 좌우 공백 제거
            String locateQ = "select locate('de', 'abcdefg') from Member m"; // 'de'가 'abcdefg' 에서 위치하는 곳의 시작지점 (index가 1부터 시작) → Integer Type으로 반환
            String sizeQ = "select size(t.members) from Team t";

            // 사용자 정의 함수 호출
            String userFuncQ = "select function('group_concat', m.username) from Member m"; // member들의 이름을 한줄로 합쳐서 출력해주는 사용자 함수

           */
            // JPQL - 경로 표현식
            // 상태 필드
            String fieldQ1 = "select m.username from Member m"; // m.username에서 탐색 끝
            // 단일 값 연관 경로
            String fieldQ2 = "select m.team from Member m"; // Member와 Team은 N:1 관계이다. m.team은 Member와 연관된 특정 team을 갖고온다. 여기에서 더 탐색할 수 있다. (m.team.name 여기서는 탐색 끝남)
            String fieldQ3 = "select m.team.name from Member m";
            // 컬렉션 값 연관 경로
            String fieldQ4 = "select t.members from Team t"; //Team과 members는 일대다 관계이다.
            // 명시적 조인을 사용하여 별칭을 얻고, 탐색하기
            String fieldQ5 = "select m.username from Team t join t.members m";

            List<String> resultList10 = em.createQuery(fieldQ5, String.class)
                    .getResultList();

            for (String s : resultList10) {
                System.out.println("s = " + s);
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
