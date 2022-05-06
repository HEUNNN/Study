package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MemberService {
    // 회원 서비스를 만들기 위해서는 member repository가 필요
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
// MemberRepository 는 Interface이고 이 Interface를 implement(구현)한 것이 MemoryMemberRepository이다.

    // 회원 가입
    public Long join(Member member) {
        // 이름 중복 허용 X
        // ifPresent()는 Optional method, Optional<T>에 null이 아닌 값이 있으면 ifPresent 매개변수로 전달된 람다식이 수행
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()) // Optional<Member> type 반환
                        .ifPresent(m -> {
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        });
    }

    // 전체회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
