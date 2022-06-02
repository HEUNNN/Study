package hello.core.member;

public interface MemberRepository {

    // 저장소를 다루는 도구, 이 도구들을 활용하여 고객들이 사용할 서비스를 만든다.
    void save(Member member);

    Member findById(Long id);
}
