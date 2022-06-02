package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@Controller
public class MemberController {
    private final MemberService memberService;

    // controller는 component scanning으로 빈과 연결할 수 밖에 없다.
    @Autowired
    public MemberController(MemberService memberService) { // 생성자 주입: Dependency Injection(의존 관계 주입)을 생성자를 통해서 한다.
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        System.out.println(form.getName());
        System.out.println(member.getName());
        memberService.join(member);

        return "redirect:/"; // 회원가입이 끝나면 '/'으로 보
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();

        model.addAttribute("members", members); // key: "members", value: members (List<Member> type)
        return "members/memberList";
    }
}
