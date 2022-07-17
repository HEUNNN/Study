package JpaBook.JpaShop.service;

import JpaBook.JpaShop.domain.Member;
import JpaBook.JpaShop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) // readOnly = true 는 데이터의 변경이 없는 읽기 전용 메서드에 사용한다. 성능 향상 효과가 있다.
@RequiredArgsConstructor
public class MemberService {

    // 필드 주입
    /*
    @Autowired // 스프링 빈에 등록되어 있는 MemberRepository 구현체를 자동으로 주입해준다.
    private MemberRepository memberRepository;
    */

    // 생성자 주입 → 필드 주입보다 더 좋은 방식이다.
    private final MemberRepository memberRepository;
    // @RequiredArgsConstructor를 사용하면 꼭필요한 final 필드의 생성자를 자동으로 생성해준다.
    // 생성자가 하나면 @Autowired를 생략해도 자동으로 DI가 된다.

    // Setter 주입 방식
/*    private MemberRepository memberRepository;

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }*/


    // 회원 서비스는 리포지토리에 있는 save, findOne, findAll, findByName 등을 사용하여 서비스를 만들어 낸다.
    // 물론 도메인에 접근이 가능하다.

    // 회원 가입
    @Transactional
    public Long join(Member member) { // 변경 = 읽기 전용 메서드 X
        validateDuplicateMember(member); // 중복 회원 검증 → 이미 그 이름으로 가입된 회원이 있다면 예외가 발생한다.
        memberRepository.save(member); // Member 인스턴스를 생성하고 저장하면, MemberRepository의 save에서 em.persist가 일어나서 id가 매핑된다.
        return member.getId();
    }

    private void validateDuplicateMember(Member member) { // 조회 = 읽기 전용 메서드 O

        List<Member> findMembers = memberRepository.findByName(member.getName());

        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    // 회원 전체 조회
    public List<Member> findMembers() { // 조회 = 읽기 전용 메서드 O
        List<Member> allMembers = memberRepository.findAll();
        return allMembers;
    }

    public Member findOne(Long id) { // 조회 = 읽기 전용 메서드 O
        Member findMember = memberRepository.findOne(id);
        return findMember;
    }
}
