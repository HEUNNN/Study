package study.datajpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import study.datajpa.domain.Member;
import study.datajpa.dto.MemberDto;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // Spring Data JPA 의 Repository

    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);

    // JPA NamedQuery 사용
    @Query(name = "Member.findByUsername")
    List<Member> findByUsername(@Param("username") String username);

    // Repository method에 쿼리 정의하기
    @Query("select m from Member m where m.username = :username and m.age = :age")
    List<Member> findUser(@Param("username") String username, @Param("age") int age);

    // 단순히 값 하나 조회
    @Query("select m.username from Member m")
    List<String> findUsernameList();

    // DTO로 직접 조회
    @Query("select new study.datajpa.dto.MemberDto(m.id, m.username, t.name) " +
            "from Member m join m.team t")
    List<MemberDto> findMemberDto();

    // 컬렉션 파라미터 바인딩
    @Query("select m from Member m where m.username in :names")
    List<Member> findByNames(@Param("names") List<String> names);

    List<Member> findListByUsername(String username); // 컬렉션 반환 타입

    Member findMemberByUsername(String username); // 단건 반환 타입

//    Page<Member> findByAge(int age, Pageable pageable);
//    Slice<Member> findByAge(int age, Pageable pageable);

    // count 쿼리를 분리한 page
    @Query(value = "select m from Member m left join m.team",
            countQuery = "select count(m) from Member m")
    // count 할 때는 join할 필요 없다. ?
    Page<Member> findByAge(int age, Pageable pageable);

    // 벌크 수정 쿼리
    @Modifying(clearAutomatically = true)
    @Query("update Member m set m.age = m.age + 1 where m.age >= :age")
    int bulkAgePlus(@Param("age") int age);

    //fetch join
    @Query("select m from Member m left join fetch m.team")
    List<Member> findMemberFetchJoin();

    // Entity Graph
    @Override // 재정의
    @EntityGraph(attributePaths = {"team"})
    List<Member> findAll();

    // JPQL + Entity graph
    @EntityGraph(attributePaths = {"team"})
    @Query("select m from Member m")
    List<Member> findMemberEntityGraph();

    // 메서드 이름으로 쿼리 짜준다. + fetch join
    @EntityGraph(attributePaths = {"team"})
    List<Member> findEntityGraphByUsername(@Param("username") String username); // find다음에 오는 EntityGraph는 아무 의미를 가지지 않는다. find + By 사이에 오는 단어는 스프링 JPA에서 쿼리 만들때 신경쓰지 않음

    // JPA Hint
    @QueryHints(value = @QueryHint(name = "org.hibernate.readOnly", value = "true"))
    Member findReadOnlyByUsername(String username);

    // Lock
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<Member> findLockByUsername(String username);
}

