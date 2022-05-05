package hello.hellospring.repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import hello.hellospring.domain.Member;
import org.junit.jupiter.api.*;

import java.util.List;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // test 하나 끝날 때마다 clear 해야함 -> Test가 진행되는 순서에 따라 결과가 달라지면 안되기 때문에(의존성을 없애줘야 함)
    @AfterEach // AfterEach: 메서드 실행 끝날 때마 어떤 동작을 하는 method를 지칭
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        // Member save test
        Member member = new Member();
        member.setName("spring");

        repository.save(member); // id 생성됨
        Member res1 = repository.findById(member.getId()).get(); // findById() return type이 Optional<Member>이라서 .get() 사용하면 Member타입의 인스턴스가 반환
        Assertions.assertEquals(res1, member); // res1과 member 같은지 비교

    }
    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result1 = repository.findByName("spring1").get(); // member1.getName() == spring1
        Member result2  = repository.findByName("spring2").get();
        Assertions.assertEquals(result1, member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member member3 = new Member();
        member3.setName("spring3");
        repository.save(member3);

        List<Member> list = repository.findAll();

        Assertions.assertEquals(list.size(), 3);
    }

}
