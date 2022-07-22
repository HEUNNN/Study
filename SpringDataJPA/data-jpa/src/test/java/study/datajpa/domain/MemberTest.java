package study.datajpa.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.repository.MemberRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    MemberRepository memberRepository;
    @Test
    @Rollback(value = false)
    public void testEntity() {
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");

        em.persist(teamA);
        em.persist(teamB);

        Member member1 = new Member("member1", 10, teamA);
        Member member2 = new Member("member2", 20, teamA);
        Member member3 = new Member("member3", 30, teamB);
        Member member4 = new Member("member4", 40, teamB);

        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);

        // 초기화
        em.flush();
        em.clear();

        // 확인
        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();

        for (Member m : members) {
            System.out.println("member: " + m);
            System.out.println("→ member.team: " + m.getTeam());
        }
    }

    // 순수 JPA - Auditing test
/*    @Test
    public void JpaEventBaseEntity() throws Exception {
        // given
        Member member = new Member("member1");
        memberRepository.save(member); // PrePersist

        Thread.sleep(1000);
        member.setUsername("member22");


        // 트랜잭션 끝나야 tx.commit ??
        em.flush();
        em.clear();
        // 왜 em.flush, clear 해야만 시간이 제대로 출력될까? DB에는 시간은 제대로 저장되어 있긴한데, 출력만 안됨

        Member findMember = memberRepository.findById(member.getId()).get();

        System.out.println("findMember.userName = " + findMember.getUsername());
        System.out.println("findMember.createdDate = " + findMember.getCreatedDate());
        System.out.println("findMember.updatedDate = " + findMember.getLastModifiedDate());
        System.out.println("findMember.createdBy = " + findMember.getCreatedBy());
        System.out.println("findMember.updatedBy = " + findMember.getLastModifiedBy());
    }*/
}