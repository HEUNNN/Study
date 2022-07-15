package JpaBook.JpaShop.repository;

import JpaBook.JpaShop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext
    EntityManager em;

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

    public List<Member> findMember(String name) {

        List<Member> findByNameMembers = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return findByNameMembers;
    }
}
