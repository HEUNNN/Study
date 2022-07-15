package JpaBook.JpaShop.repository;

import JpaBook.JpaShop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {

    // 필드 주입
    @PersistenceContext
    private EntityManager em;

    // 생성자 주입 → 스프링 데이터 JPA를 사용하면 EntityManager도 주입 가능
//    private final EntityManager em;

    public void save(Member member) {

        em.persist(member);
    }

    public Member findOne(Long id) {

        Member findMember = em.find(Member.class, id); // 단건 조회
        return findMember;
    }

    public List<Member> findAll() {

        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
        return members;
    }

    public List<Member> findByName(String name) {

        List<Member> findByNameMembers = em.createQuery("select m from Member m where m.userName = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return findByNameMembers;
    }
}
