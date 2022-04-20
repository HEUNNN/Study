package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MemoryMemberRepository implements MemberRepository{
    // 자바의 정석 공부하고 다시 할 것
    // save 할 공간 -> MAP인 store 생성
    private static Map<Long, Member> store = new HashMap<>(); // Key, Value의 타입인 Long, Member
    private static long sequence = 0L; // key 값을 자동으로 생성해준다.

    @Override
    public Member save(Member member) { // 이름은 이미 넘어온 상태, 시스템에서 정해주는 id 값만 정해주면 된다.
        member.setId(++sequence);
        store.put(member.getId(), member); // Map에 저장
        return member; // Member
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable((store.get(id))); // id 가 Null일 수 있으니 감싸준다.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}
