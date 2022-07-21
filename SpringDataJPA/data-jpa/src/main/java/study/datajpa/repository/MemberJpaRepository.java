package study.datajpa.repository;

import org.springframework.stereotype.Repository;
import study.datajpa.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class MemberJpaRepository {

    @PersistenceContext
    private EntityManager em;

    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    public void delete(Member member) {
        em.remove(member);
    }

    public List<Member> findAll() {
        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
        return members;
    }

    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    public long count() {
        Long countResult = em.createQuery("select count(m) from Member m", Long.class).getSingleResult();
        return countResult;
    }

    public Member find(Long id) {
        Member findMember = em.find(Member.class, id);
        return findMember;
    }

    public List<Member> findByUsernameAndAgeGreaterThan(String username, int age) {

        List result = em.createQuery("select m from Member m where m.username = :username and m.age > :age").setParameter("username", username).setParameter("age", age).getResultList();
        return result;
    }

    // NamedQuery
    public List<Member> findByUsername(String username) {
        return em.createNamedQuery("Member.findByUsername", Member.class).setParameter("username", username).getResultList();
    }

    public void flush() {
        em.flush();
        em.clear();
    }

    public List<Member> findByPage(int age, int offset, int limit) {
        List<Member> result = em.createQuery("select m from Member m where m.age = :age order by m.username desc", Member.class).setParameter("age", age).setFirstResult(offset).setMaxResults(limit).getResultList();

        return result;
    }

    public long totalCount(int age) {
        Long countResult = em.createQuery("select count(m) from Member m where m.age = :age", Long.class).setParameter("age", age).getSingleResult();

        return countResult;
    }

    // 벌크
    public int bulkAgePlus(int age) {
        int resultCount = em.createQuery("update Member m set m.age = m.age + 1 where m.age >= :age")
                .setParameter("age", age)
                .executeUpdate();
        return resultCount;
    }
}
