package JpaBook.JpaShop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {


    @PersistenceContext // 스프링 부트가 해당 어노테이션이 붙어있으면 자동으로 EntityManager를 주입해준다.
    EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member find(Long id) {
        Member findMember = em.find(Member.class, id);
        return findMember;
    }
}
