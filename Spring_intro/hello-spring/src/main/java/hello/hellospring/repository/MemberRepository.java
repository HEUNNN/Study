package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    // Member Repository의 4가지 기능 구현
    Member save(Member member); // abstract method
    Optional<Member> findById(Long id); // find 결과값이 null일 수 있기때문에 Optional로 감싸서 반환한다.
    Optional<Member> findByName(String name);
    List<Member> findAll(); // 지금까지 저장한 Member를 List 타입으로 반환해주는 method
}
