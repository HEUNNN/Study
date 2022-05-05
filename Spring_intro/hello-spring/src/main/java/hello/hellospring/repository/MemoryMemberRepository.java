package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{
  // 회원 객체의 저장소

    private static Map<Long, Member> store = new HashMap<>(); // Map<Long, Member> type의 store 참조변수 생성
    private static long sequence = 0L; // key값인 id를 생성해준다.

    @Override
    public Member save(Member member) { // save method의 파라미터로 Member 인스턴스가 들어온다.
        member.setId(++sequence); // Member class의 setter -> setId()
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
        // Optional.of(), Optional.ofNullable() 은 Optional 객체를 생성한다.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); // Optional로 반환이 된다.
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<Member>(store.values());
    }

    // Test 시 사용할 clear method
    public void clearStore() {
        store.clear();
    }
}
