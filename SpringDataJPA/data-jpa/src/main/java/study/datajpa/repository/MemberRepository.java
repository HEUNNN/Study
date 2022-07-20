package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.datajpa.domain.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // Spring Data JPA 의 Repository

    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);
}
