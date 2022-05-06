package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    // controller는 component scanning으로 빈과 연결할 수 밖에 없다.
    @Autowired
    public MemberController(MemberService memberService)  { // 생성자 주입: Dependency Injection(의존 관계 주입)을 생성자를 통해서 한다.
        this.memberService = memberService;
    }
}
