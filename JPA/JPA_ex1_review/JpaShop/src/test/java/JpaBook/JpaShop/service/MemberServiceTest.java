package JpaBook.JpaShop.service;

import JpaBook.JpaShop.domain.Member;
import JpaBook.JpaShop.repository.MemberRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager em;

    @Test
//    @Rollback(value = false)
    public void 회원가입() throws Exception {

        Member member = new Member();
        member.setUserName("kim apple");

        Long savedId = memberService.join(member);

        em.flush(); // flush할 때 쿼리를 볼 수 있음
//        em.clear(); // clear 까지 하면 영속성 컨텍스트가 비워지기 때문에 동일성 보장이 안되어서 테스트에 실패하게 된다.

        Assertions.assertEquals(member, memberRepository.findOne(savedId));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception {
        Member member1 = new Member();
        member1.setUserName("kim");

        Member member2 = new Member();
        member2.setUserName("kim");

        memberService.join(member1);
        memberService.join(member2); // 여기서 예외 발생

        fail("예외가 발생해야 하는데, 발생하지 않았다.");
    }
}