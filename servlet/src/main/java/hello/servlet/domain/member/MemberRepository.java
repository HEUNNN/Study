package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); // static이라서 MemerRepository 인스턴스가 여러개 생성되어도 store 저장소는 한개만 생성된다.
    private static long sequence = 0L;

    // Spring을 사용하지 않기 때문에 직접 싱글톤처럼 동작하도록 코드를 작성해야한다.
    // MemberRepository 인스턴스를 private static으로 생성하고 private 생성자를 두어 외부에서 누군가 생성하지 못하도록 막는다.
    // 외부 사용자들은 이미 만들어져 있는 MemberRepository 인스턴스를 반환받아서 사용하도록 getInstance()를 만든다.
    // → 싱글톤으로 동작하도록 처리를 하면 MemberRepository의 필드값인 store, sequence도 static을 지워도 된다.
    private static final MemberRepository instance = new MemberRepository();

    private MemberRepository() {
        // 생성자
    }

    public static MemberRepository getInstance() {
        return instance;
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member; // 아이디가 저장된 member 반환
    }

    public Member findById(Long id) {
        Member member = store.get(id);
        return member;
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}