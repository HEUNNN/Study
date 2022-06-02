package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>,  MemberRepository{
    // Spring data JPA는 JpaRepository를 extends하는 인터페이스의 구현체를 자동으로 만들어주고 spring bin에 자동으로 등록해준다.
    @Override
    Optional<Member> findByName(String name);
    // findByName을 정의하면 spring data jpa는 'select m from Member m where m.name = ? '으로 쿼리를 자동으로 짜준다.
    // 인터페이스 이름을 작성하는 규칙이 있다. ex) find / By / Name
}
