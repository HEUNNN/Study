package hello.login.web.member;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller // 객체를 스프링 빈으로 등록하고, 애노테이션 기반의 컨트롤러임을 나타낸다.
@RequiredArgsConstructor // private 필드를 생성하는 생성자를 자동으로 만들어줌
@RequestMapping("/members")
public class MemberController {

    private final MemberRepository memberRepository; // 의존 관계 자동 주입
    // @RequiredArgsConstructor로 private 필드를 생성하는 생성자를 만든다. 그리고 생성자가 1개이면 @Autowired를 생략해도 자동주입이 된다.

    @GetMapping("/add")
    public String addForm(@ModelAttribute("member") Member member) { // login form을 GET /add 로 불러 올 때는 비어있는 Member 객체를 model에 담아준다. 나중에 검증 때 유용하게 사용된다.
        return "members/addMemberForm"; // view 이름 반환
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute Member member, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "members/addMemberForm";
        }

        memberRepository.save(member);
        return "redirect:/";
    }
}
