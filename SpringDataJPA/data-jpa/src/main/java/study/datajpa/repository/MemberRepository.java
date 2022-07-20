package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import study.datajpa.domain.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // Spring Data JPA 의 Repository

    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);

    // JPA NamedQuery 사용
//    @Query(name = "Member.findByUsername")
//    List<Member> findByUsername(@Param("username") String username);

    // Repository method에 쿼리 정의하기
    @Query("select m from Member m where m.username = :username and m.age = :age")
    List<Member> findUser(@Param("username") String username, @Param("age") int age);
}
