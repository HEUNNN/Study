package study.datajpa.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.domain.Member;
import study.datajpa.domain.Team;
import study.datajpa.dto.MemberDto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    @PersistenceContext // 같은 트랜잭션 안에서는 memberRepository의 em이나 여기서 선언한 em이나 같다.
    EntityManager em;

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

    @Test
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

        Page<MemberDto> toMap = page.map(member -> new MemberDto(member.getId(), member.getUsername(), null));

        // then
        List<MemberDto> content = toMap.getContent(); // 조회된 데이터

        assertThat(content.size()).isEqualTo(3); // 조회된 데이터 수
        assertThat(toMap.getTotalElements()).isEqualTo(6); // 전체 데이터 수
        assertThat(toMap.getNumber()).isEqualTo(0); // 페이지 번호
        assertThat(toMap.getTotalPages()).isEqualTo(2); // 전체 페이지 번호
        assertThat(toMap.isFirst()).isTrue(); // 첫번째 항목인가?
        assertThat(toMap.hasNext()).isTrue(); // 다음 페이지가 있는가?

    }

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
        PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "username")); // PrageRequest는 pageable의 구현체, Pageable은 인터페이스.

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

    @Test
    public void findMemberLazy() {
        // member1 → teamA
        // member2 → teamB

        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");

        teamRepository.save(teamA);
        teamRepository.save(teamB);

        Member member1 = new Member("member1");
        member1.changeTeam(teamA);
        Member member2 = new Member("member2");
        member2.changeTeam(teamB);

        memberRepository.save(member1);
        memberRepository.save(member2);

        em.flush();
        em.clear();

        // when
        List<Member> members = memberRepository.findAll();
        for (Member member : members) {
            System.out.println("member = " + member.getUsername());
            System.out.println("member.getTeam().getClass() = " + member.getTeam().getClass() );
            System.out.println("member = " + member.getTeam().getName());
        }
    }

    @Test
    public void fetchjoin() {
        // member1 → teamA
        // member2 → teamB

        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");

        teamRepository.save(teamA);
        teamRepository.save(teamB);

        Member member1 = new Member("member1");
        member1.changeTeam(teamA);
        Member member2 = new Member("member2");
        member2.changeTeam(teamB);

        memberRepository.save(member1);
        memberRepository.save(member2);

        em.flush();
        em.clear();

        // when
        List<Member> members = memberRepository.findMemberFetchJoin();
        for (Member member : members) {
            System.out.println("member = " + member.getUsername());
            System.out.println("member.getTeam().getClass() = " + member.getTeam().getClass() );
            System.out.println("member = " + member.getTeam().getName());
        }
    }

    @Test
    public void entityGraph() {
        // member1 → teamA
        // member2 → teamB

        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");

        teamRepository.save(teamA);
        teamRepository.save(teamB);

        Member member1 = new Member("member1");
        member1.changeTeam(teamA);
        Member member2 = new Member("member2");
        member2.changeTeam(teamB);

        memberRepository.save(member1);
        memberRepository.save(member2);

        em.flush();
        em.clear();

        // when
        List<Member> members = memberRepository.findAll() ;
        for (Member member : members) {
            System.out.println("member = " + member.getUsername());
            System.out.println("member.getTeam().getClass() = " + member.getTeam().getClass() );
            System.out.println("member = " + member.getTeam().getName());
        }
    }

    @Test
    public void findEntityGraphByUsername() {
        // member1 → teamA
        // member2 → teamB

        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");

        teamRepository.save(teamA);
        teamRepository.save(teamB);

        Member member1 = new Member("member1");
        member1.changeTeam(teamA);
        Member member2 = new Member("member1");
        member2.changeTeam(teamB);

        memberRepository.save(member1);
        memberRepository.save(member2);

        em.flush();
        em.clear();

        // when
        List<Member> members = memberRepository.findEntityGraphByUsername("member1") ;
        for (Member member : members) {
            System.out.println("member = " + member.getUsername());
            System.out.println("member.getTeam().getClass() = " + member.getTeam().getClass() );
            System.out.println("member = " + member.getTeam().getName());
        }
    }

    @Test
    public void queryHint() {
        // given
        Member member = new Member("member1", 10);
        memberRepository.save(member);

        em.flush();
        em.clear();

        // when
/*        Member findMember1 = memberRepository.findById(member.getId()).get();
        findMember1.setUsername("member2"); // 변경 감지 동작 → UPDATE 쿼리 나간다.*/

        Member findMember2 = memberRepository.findReadOnlyByUsername("member1"); // Query 힌트를 달아둬서 변경 감지가 안된다. 스냅샷 자체가 없기 때문이다.
        findMember2.setUsername("aaa");

    }

    @Test
    public void lock() {
        // given
        Member member = new Member("member1", 10);
        memberRepository.save(member);

        em.flush();
        em.clear();

        List<Member> lockMembers = memberRepository.findLockByUsername("member1");
    }

    // 사용자 정의 리포지토리 메서드 사용
    @Test
    public void custom() {

        Member member1 = new Member("member1", 10);
        Member member2 = new Member("member2", 20);
        Member member3 = new Member("member3", 30);
        Member member4 = new Member("member4", 40);

        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);
        memberRepository.save(member4);

        List<Member> findMembers = memberRepository.findMemberCustom();

        assertThat(findMembers.size()).isEqualTo(4);
        assertThat(findMembers.get(0).getUsername()).isEqualTo("member1");

    }

    @Test
    public void queryByExample() {
        Team teamA = new Team("teamA");
        em.persist(teamA);

        Member m1 = new Member("m1", 0, teamA);
        Member m2 = new Member("m2", 0, teamA);
        em.persist(m1);
        em.persist(m2);

        em.flush();
        em.clear();

        Member member = new Member("m1"); // 해당 도메인 객체를 갖고 검색 조건을 만든다. 좀 더 상세한 검색 조건을 만들려면 ExampleMatcher를 사용한다.
//        Example<Member> example = Example.of(member);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("age");

        Example<Member> example = Example.of(member, matcher);

        List<Member> result = memberRepository.findAll(example);

        Assertions.assertThat(result.get(0).getUsername()).isEqualTo("m1");

    }

    @Test
    public void projections() {
        Team teamA = new Team("teamA");
        em.persist(teamA);

        Member m1 = new Member("m1", 0, teamA);
        Member m2 = new Member("m2", 0, teamA);
        em.persist(m1);
        em.persist(m2);

        em.flush();
        em.clear();

        List<UsernameOnly> result = memberRepository.findProjectionByUsername("m1");

        for (UsernameOnly usernameOnly : result) {
            System.out.println("usernameOnly: " + usernameOnly);
        }
    }

    // Native Query Test
    @Test
    public void nativeQuery() {
        Team teamA = new Team("teamA");
        em.persist(teamA);

        Member m1 = new Member("m1", 0, teamA);
        Member m2 = new Member("m2", 0, teamA);
        em.persist(m1);
        em.persist(m2);

        em.flush();
        em.clear();

        // when
        Member result = memberRepository.findByNativeQuery("m1");
        System.out.println(result);
    }

    // Native Projections test
/*    @Test
    public void nativeProjections() {
        Team teamA = new Team("teamA");
        em.persist(teamA);

        Member m1 = new Member("m1", 0, teamA);
        Member m2 = new Member("m2", 0, teamA);
        em.persist(m1);
        em.persist(m2);

        em.flush();
        em.clear();

        // when
        Page<MemberProjection> result = memberRepository.findByNativeProjection(PageRequest.of(1, 10));
        List<MemberProjection> content = result.getContent();
        for (MemberProjection memberProjection : content) {
            System.out.println("memberProjection = " + memberProjection.getUsername());
            System.out.println("memberProjection = " + memberProjection.getTeamName());
        }
    }*/
}