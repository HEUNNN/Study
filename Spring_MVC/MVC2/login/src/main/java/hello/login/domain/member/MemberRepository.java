package hello.login.domain.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;


@Slf4j
@Repository // component scan 기능
public class MemberRepository {
    private static Map<Long, Member> store = new HashMap<>(); // static 사용
    private static long sequence = 0L; // static 사용

    public Member save(Member member) {
        member.setId(++sequence);
        log.info("save: member = {}", member);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(long id) {
        Member member = store.get(id);
        return member;
    }

    // login id로 member 찾기
    // Optional class : If no value is present, the object is considered empty and isPresent() returns false.
    public Optional<Member> findByLoginId(String loginId) {
        /*
        List<Member> all = findAll();
        for (Member member : all) {
            if (member.getLonginId().equals(loginId)) {
                return Optional.of(member);
            }
        }
        return Optional.empty();
        */

        // Java8의 stream과 람다식을 사용하여 위의 코드를 간단하게 표현할 수 있다.
        // Stream<Member> stream = findAll().stream();

        return findAll().stream()
                .filter(member -> member.getLoginId().equals(loginId))
                .findFirst();

    }

    public List<Member> findAll() {
        ArrayList<Member> members = new ArrayList<>(store.values());
        // Collection<Member> values = store.values();
        // ArrayList(Collection c): 주어진 컬렉션이 저장된 ArrayList를 생성한다.
        // Collection: list, set, map 등..
        // store.values()는 Collection 타입의 Collection<Member>를 반환한다.
        return members;
    }

    public void clearStore() {
        store.clear();
    }
}
