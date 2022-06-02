package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;
    // JPA는 EntityManager로 모든것이 동작, gradle에 data-jpa만 있으면 spring boot가 자동으로 생성해줌
    // JPA는 application.properties setting과 DB connection 정보 등을 합하여 Spring boot가 EntityManager를 생성한다.
    // EntityManager는 내부적으로 data source를 들고 있어 DB와의 통신 등을 내부에서 다 처리한다.
    // EntityManager는 injection 처리를 해주어야 한다.

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member); // JPA가 insert 쿼리 짜서 member를 DB table에 다 집어 넣고, member.setId(id) 작업도 해준다.
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        // find(className.class, id)를 하는 이유
        // DB table에서 해당 id에 맞는 member 정보를 찾아와, Member 객체로 만들어줘야 한다.
        // Member 객체로 만들어야하니까 그 객체의 정보(Member.class)를 넘겨주어야 한다.
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class) // 조회 타입: Member.class
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        List<Member> result =  em.createQuery("select m from Member m", Member.class)  // 조회 타입: Member.class
                .getResultList();
        return result;
    }
}
