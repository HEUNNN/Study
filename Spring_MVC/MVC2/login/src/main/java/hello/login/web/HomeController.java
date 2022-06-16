package hello.login.web;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@Data
public class HomeController {
    private final MemberRepository memberRepository;

    // @GetMapping("/")
    public String home() {
        return "home";
    }

    // LoginController에서 login 처리에 성공하면 redirect:/, 즉 / 경로로 GET HTTP 요청이 날라온.
    @GetMapping("/")
    public String homeLogin(@CookieValue(name = "memberId", required = false) Long memberId, Model model) {
        if (memberId == null) {
            return "home";
        }

        // 로그인 성공한 사용자
        Member loginMember = memberRepository.findById(memberId);
        if (loginMember == null) {
            return "home";
        }
        model.addAttribute("member", loginMember); // loginHome view에서 사용할 loginMember 데이터를 model에 담아서 넘겨준다.
        return "loginHome";
    }
}