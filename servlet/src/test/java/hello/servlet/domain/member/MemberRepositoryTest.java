package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemberRepositoryTest {
    MemberRespository memberRespository = MemberRespository.getInstance(); // singlton

    @AfterEach  // Test가 끝날때마다 초기화하기 위한 작업
    void afterEach() {
        memberRespository.clearStore();
    }

    @Test
    void save() {
        // given
        Member member = new Member("leehyeeun", 25);

        // when
        Member savedMember = memberRespository.save(member);

        // then
        Member findMember = memberRespository.findById(savedMember.getId());

        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll() {
        // given
        Member member1 = new Member("kim", 21);
        Member member2 = new Member("lee", 22);

        memberRespository.save(member1);
        memberRespository.save(member2);

        // when
        List<Member> memberList = memberRespository.findAll();

        // then
        assertThat(memberList.size()).isEqualTo(2);
        assertThat(memberList).contains(member1, member2);

    }
}
