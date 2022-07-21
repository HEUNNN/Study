package study.datajpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.domain.Member;
import study.datajpa.domain.Team;
import study.datajpa.dto.MemberDto;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository; // Spring data JPA의 repository
    @Autowired
    TeamRepository teamRepository;

//    @Transactional // Transactional이 여기 있어도 테스트 통과
    @Test
    public void testMember() {

        Member member = new Member("member Lee");
        Member savedMember = memberRepository.save(member);

        Member findMember = memberRepository.findById(member.getId()).get();

        assertThat(findMember.getId()).isEqualTo(savedMember.getId());
        assertThat(findMember.getUsername()).isEqualTo(savedMember.getUsername());
        assertThat(findMember).isEqualTo(savedMember); // JPA 엔티티 동일성 보장
    }

    @Test
    public void basicCRUD() {
        Member member1 = new Member("kim", 10);
        Member member2 = new Member("kim", 20);

        memberRepository.save(member1);
        memberRepository.save(member2);

        // 단건 조회 검증
        Member findMember1 = memberRepository.findById(member1.getId()).get();
        Member findMember2 = memberRepository.findById(member2.getId()).get();
        assertThat(findMember1).isEqualTo(member1);
        assertThat(findMember2).isEqualTo(member2);

        // 리스트 조회 검증
        List<Member> members = memberRepository.findAll();
        assertThat(members.size()).isEqualTo(2);

        // 이름과 나이를 기준으로 회원 조회
        List<Member> result = memberRepository.findByUsernameAndAgeGreaterThan("kim", 15);
        assertThat(result.get(0).getUsername()).isEqualTo("kim");
        assertThat(result.get(0).getAge()).isEqualTo(20);
        assertThat(result.size()).isEqualTo(1);

        // JPA의 DirtyCheck
//        member1.setUsername("kim");
//        System.out.println("DirtyCheck: " + member1.getUsername());

        // 카운트 검증
        long count = memberRepository.count();
        assertThat(count).isEqualTo(2);

        // 삭제 검증
        memberRepository.delete(member1);
        memberRepository.delete(member2);

        long deletedCount = memberRepository.count();
        assertThat(deletedCount).isEqualTo(0);

    }

//    @Test
/*    public void testNamedQuery() {
        Member member1 = new Member("kim", 10);
        Member member2 = new Member("lee", 20);

        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member> result = memberRepository.findByUsername("kim");

        assertThat(result.get(0).getUsername()).isEqualTo("kim");
        assertThat(result.get(0).getAge()).isEqualTo(10);
        assertThat(result.size()).isEqualTo(1);
    }*/

    @Test
    public void testRepositoryQuery() {
        Member member1 = new Member("kim", 10);
        Member member2 = new Member("lee", 20);

        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member> result = memberRepository.findUser("kim", 10);

        assertThat(result.get(0).getUsername()).isEqualTo("kim");
        assertThat(result.get(0).getAge()).isEqualTo(10);
        assertThat(result.size()).isEqualTo(1);
    }

    @Test
    public void testQuery() {
        Member member1 = new Member("kim", 10);
        Member member2 = new Member("lee", 20);

        memberRepository.save(member1);
        memberRepository.save(member2);

        List<String> usernameList = memberRepository.findUsernameList();
        assertThat(usernameList.get(0)).isEqualTo("kim");
        assertThat(usernameList.get(1)).isEqualTo("lee");
        assertThat(usernameList.size()).isEqualTo(2);
    }

    @Test
    public void testDto() {
        Member m1 = new Member("AAA", 10);
        memberRepository.save(m1);

        Team team = new Team("teamA");
        m1.setTeam(team);
        teamRepository.save(team);

        List<MemberDto> result = memberRepository.findMemberDto();

        for (MemberDto memberDto : result) {
            System.out.println("DTO = " + memberDto);
        }
    }

    @Test
    public void collectioParamTest() {

        Member member1 = new Member("kim", 10);
        Member member2 = new Member("lee", 20);

        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member> byNames = memberRepository.findByNames(Arrays.asList("kim", "lee"));

        for (Member byName : byNames) {
            System.out.println("member = " + byName);
        }
    }

    @Test
    public void returnType() {
        Member member1 = new Member("kim", 10);
        Member member2 = new Member("lee", 20);

        memberRepository.save(member1);
        memberRepository.save(member2);

        List<Member> listResult = memberRepository.findListByUsername("kim");
        System.out.println(listResult.get(0));
    }

/*    @Test
    public void paging() {
        // given
        memberRepository.save(new Member("member1", 10));
        memberRepository.save(new Member("member2", 10));
        memberRepository.save(new Member("member3", 10));
        memberRepository.save(new Member("member4", 10));
        memberRepository.save(new Member("member5", 10));
        memberRepository.save(new Member("member6", 20));

        int age = 10;
        PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "username"));

        // when
        Page<Member> page = memberRepository.findByAge(age, pageRequest);

        // then
        List<Member> content = page.getContent(); // 조회된 데이터
        assertThat(content.size()).isEqualTo(3); // 조회된 데이터 수
        assertThat(page.getTotalElements()).isEqualTo(5); // 전체 데이터 수
        assertThat(page.getNumber()).isEqualTo(0); // 페이지 번호
        assertThat(page.getTotalPages()).isEqualTo(2); // 전체 페이지 번호
        assertThat(page.isFirst()).isTrue(); // 첫번째 항목인가?
        assertThat(page.hasNext()).isTrue(); // 다음 페이지가 있는가?

    }*/

    @Test
    public void slice() {
        // given
        memberRepository.save(new Member("member1", 10));
        memberRepository.save(new Member("member2", 10));
        memberRepository.save(new Member("member3", 10));
        memberRepository.save(new Member("member4", 10));
        memberRepository.save(new Member("member5", 10));
        memberRepository.save(new Member("member6", 20));

        int age = 10;
        PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "username"));

        // when
        Slice<Member> slice = memberRepository.findByAge(age, pageRequest);

        // then
        List<Member> content = slice.getContent(); // 조회된 데이터
        assertThat(slice.getNumber()).isEqualTo(0); // 페이지 번호
        assertThat(slice.isFirst()).isTrue(); // 첫번째 항목인가?
        assertThat(slice.hasNext()).isTrue(); // 다음 페이지가 있는가?

    }

    @Test
    public void bulkUpdate() {
        memberRepository.save(new Member("member1", 12));
        memberRepository.save(new Member("member2", 14));
        memberRepository.save(new Member("member3", 15));
        memberRepository.save(new Member("member4", 30));
        memberRepository.save(new Member("member5", 23));
        memberRepository.save(new Member("member6", 60));

        int age = 20;
        int i = memberRepository.bulkAgePlus(age);

        Member findMember = memberRepository.findMemberByUsername("member4");

        System.out.println(findMember.getAge());

        assertThat(i).isEqualTo(3);
        System.out.println(i);
    }
}