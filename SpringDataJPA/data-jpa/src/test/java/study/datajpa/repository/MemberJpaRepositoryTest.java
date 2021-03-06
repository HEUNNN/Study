package study.datajpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.domain.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
@Rollback(false)
class MemberJpaRepositoryTest {

    @Autowired
    MemberJpaRepository memberJpaRepository; // 스프링 빈 컨텍스트에서 관리하는 객체들을 자동으로 주입해주는 것은 Spring의 기능

    @Test
    public void testMember() {
        Member member = new Member("memberA");

        Member savedMember = memberJpaRepository.save(member);
//        memberJpaRepository.flush();
        Member findMember = memberJpaRepository.find(savedMember.getId());

        assertThat(findMember.getId()).isEqualTo(savedMember.getId());
        assertThat(findMember.getUsername()).isEqualTo(savedMember.getUsername());

        assertThat(findMember).isEqualTo(member);
        // JPA는 엔티티의 동일성을 보장해준다(1차 캐시). 하지만 member를 save 한 후 flush, clear 하고 find 멤버를 한 경우에는 동일성 보장 X


    }

    @Test
    public void basicCRUD() {
        Member member1 = new Member("kim", 10);
        Member member2 = new Member("kim", 20);

        memberJpaRepository.save(member1);
        memberJpaRepository.save(member2);

        // 단건 조회 검증
        Member findMember1 = memberJpaRepository.findById(member1.getId()).get();
        Member findMember2 = memberJpaRepository.findById(member2.getId()).get();
        assertThat(findMember1).isEqualTo(member1);
        assertThat(findMember2).isEqualTo(member2);

        // 리스트 조회 검증
        List<Member> members = memberJpaRepository.findAll();
        assertThat(members.size()).isEqualTo(2);

        // 이름과 나이를 기준으로 회원 조회
        List<Member> result = memberJpaRepository.findByUsernameAndAgeGreaterThan("kim", 15);
        assertThat(result.get(0).getUsername()).isEqualTo("kim");
        assertThat(result.get(0).getAge()).isEqualTo(20);
        assertThat(result.size()).isEqualTo(1);

        // JPA의 DirtyCheck
        member1.setUsername("kim");
        System.out.println("DirtyCheck: " + member1.getUsername());

        // 카운트 검증
        long count = memberJpaRepository.count();
        assertThat(count).isEqualTo(2);

        // 삭제 검증
        memberJpaRepository.delete(member1);
        memberJpaRepository.delete(member2);

        long deletedCount = memberJpaRepository.count();
        assertThat(deletedCount).isEqualTo(0);

    }

    @Test
    public void testNamedQuery() {
        Member member1 = new Member("kim", 10);
        Member member2 = new Member("lee", 20);

        memberJpaRepository.save(member1);
        memberJpaRepository.save(member2);

        List<Member> result = memberJpaRepository.findByUsername("kim");

        assertThat(result.get(0).getUsername()).isEqualTo("kim");
        assertThat(result.get(0).getAge()).isEqualTo(10);
        assertThat(result.size()).isEqualTo(1);
    }

    @Test
    public void paging() {
        // given
        memberJpaRepository.save(new Member("member1", 10));
        memberJpaRepository.save(new Member("member2", 10));
        memberJpaRepository.save(new Member("member3", 10));
        memberJpaRepository.save(new Member("member4", 10));
        memberJpaRepository.save(new Member("member5", 10));
        memberJpaRepository.save(new Member("member6", 20));

        // when
        int age = 10;
        int offset = 0;
        int limit = 4;
        List<Member> byPage = memberJpaRepository.findByPage(age, offset, limit);
        long totalCount = memberJpaRepository.totalCount(10);

        // then
        for (Member member : byPage) {
            System.out.println("member: " + member);
        }

        assertThat(byPage.size()).isEqualTo(4);
        assertThat(totalCount).isEqualTo(5);
    }

    @Test
    public void bulkUpdate() {
        memberJpaRepository.save(new Member("member1", 12));
        memberJpaRepository.save(new Member("member2", 14));
        memberJpaRepository.save(new Member("member3", 15));
        memberJpaRepository.save(new Member("member4", 30));
        memberJpaRepository.save(new Member("member5", 23));
        memberJpaRepository.save(new Member("member6", 60));

        int age = 20;
        int i = memberJpaRepository.bulkAgePlus(age);

        assertThat(i).isEqualTo(3);
        System.out.println(i);
    }
}