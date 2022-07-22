package study.datajpa.repository;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import study.datajpa.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{

    // 순수 JPA 를 사용하여 custom 해보기
    private final EntityManager em;

    @Override
    public List<Member> findMemberCustom() {

        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
