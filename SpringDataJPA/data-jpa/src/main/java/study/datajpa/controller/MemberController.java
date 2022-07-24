package study.datajpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import study.datajpa.domain.Member;
import study.datajpa.dto.MemberDto;
import study.datajpa.repository.MemberRepository;

import javax.annotation.PostConstruct;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    // 도메인 클래스 컨버터 사용 전
//    @GetMapping("/members/{id}")
    public String findMember1(@PathVariable("id") Long id) {
        Member member = memberRepository.findById(id).get();
        return member.getUsername();
    }

    // 도메인 클래스 컨버터 사용
    @GetMapping("/members/{id}")
    public String findMember2(@PathVariable("id") Member member) {
        return member.getUsername();
    }

    // one-indexed-parameters를 yml에 true로 설정하여 Page를 1 부터 시작하게할 수도 있다.
    // http://localhost:8080/members?page=1일 때랑 http://localhost:8080/members?page=0일 때랑 같아진다.
    // page 1부터 시작하니까
    @GetMapping("/members")
    public Page<MemberDto> list(@PageableDefault(size = 5) Pageable pageable) {
        Page<Member> page = memberRepository.findAll(pageable);
        Page<MemberDto> dtoPage = page.map(m -> new MemberDto(m.getId(), m.getUsername(), null));
        return dtoPage;
    }

    // Pageable, Page를 직접 만들어서 Page를 1부터 시작하기
    @GetMapping("/members2")
    public Page<MemberDto> list() {
        PageRequest request = PageRequest.of(1, 4);
        return memberRepository.findAll(request).map(MemberDto::new);
    }

//    @PostConstruct // 스프링이 애플리케이션에 올라올때(초기에) 한번 실행 시켜주는 애노테이션이다. → test시에도 적용된다.
    public void init() {
        for (int i = 0; i < 100; i++) {
            memberRepository.save(new Member("user" + i, i));
        }
    }
}
