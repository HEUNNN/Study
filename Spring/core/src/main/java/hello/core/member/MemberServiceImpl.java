package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired // Autowired를 생성자에 붙이면 spring이 MemberRepository type에 해당하는 스프링 빈을 찾아서 자동으로 의존 관계를 주입한다.
    public MemberServiceImpl(MemberRepository memberRepository) { // 추상화에만 의존하기 때문에 DIP가 지켜진다.
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // Test 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
