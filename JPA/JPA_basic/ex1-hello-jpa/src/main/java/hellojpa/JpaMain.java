package hellojpa;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin(); // database transaction 시작

        try {

            Team team1 = new Team();
            team1.setName("TeamA");
            em.persist(team1); // persist하면 id 자동으로 생성되어 부여된다.

            Team team2 = new Team();
            team2.setName("TeamB");
            em.persist(team2);

            Member member1 = new Member();
            member1.setUsername("member1");
            // member1를 team1에 포함시키고자 할 때 → 객체를 테이블에 맞추어 모델링한 경우
//            member1.setTeamId(team1.getId());
            member1.setTeam(team1);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("member2");
//            member2.setTeamId(team2.getId());
            member2.setTeam(team2);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("member3");
//            member3.setTeamId(team1.getId());
            member3.setTeam(team1);
            em.persist(member3);

            Member member4 = new Member();
            member4.setUsername("member4");
            member4.setTeam(team2);
            em.persist(member4);

            // 특정 멤버를 찾고, teamId 찾기
            Member findMember1 = em.find(Member.class, member2.getId()); // 영속성 컨텍스트에 들어가있는 상태이기 때문에 1차 캐시에서 가져온다. 쿼리를 사용하지 않는다.
            // 만약 영속성 컨텍스트 말고 DB에서 가져오게 하려면 em.persist(member3) 후에 em.flush()하여 DB에 쿼리를 날려 1차 캐시에 있는 데이터를 DB로 보내고, em.clear() 하여 영속성 컨텍스트를 초기화 한다.
            Team findTeam1 = findMember1.getTeam();
            System.out.println("findTeam = " + findTeam1.getName());

            findMember1.setTeam(team1);

            Member findMember2 = em.find(Member.class, member2.getId());
            Team findTeam2 = findMember2.getTeam();
            System.out.println("changed Team ");
            System.out.println("findTeam = " + findTeam2.getName());


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
