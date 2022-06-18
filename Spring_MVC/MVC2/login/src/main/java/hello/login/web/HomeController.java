package hello.login.web;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import hello.login.web.session.SessionManager;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@Data
public class HomeController {
    private final MemberRepository memberRepository;
    private final SessionManager sessionManager;

    // @GetMapping("/")
    public String home() {
        return "home";
    }

    // LoginController에서 login 처리에 성공하면 redirect:/, 즉 / 경로로 GET HTTP 요청이 날라온.
//    @GetMapping("/")
    public String homeLoginV1(@CookieValue(name = "memberId", required = false) Long memberId, Model model) {
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

    //    @GetMapping("/")
    public String homeLoginV2(HttpServletRequest request, Model model) { // HTTP request에서 sessionId cookie 꺼내기

        // 로그인 된 사용자인지 판단하는 로직
        // sessionManager(세션 관리자)에 저장된 회원 정보 조회
        Member member = (Member) sessionManager.getSession(request);

        if (member == null) {
            return "home";
        }

        model.addAttribute("member", member);
        return "loginHome";

    }

    //    @GetMapping("/")
    public String homeLoginV3(HttpServletRequest request, Model model) { // HTTP request에서 sessionId cookie 꺼내기

        // 로그인 된 사용자인지 판단하는 로직
        HttpSession session = request.getSession(false);

        if (session == null) {
            return "home";
        }

        Member loginMember = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);

        // 세션에 회원 데이터가 없으면 home
        if (loginMember == null) {
            return "home";
        }

        model.addAttribute("member", loginMember);
        return "loginHome";

    }

    @GetMapping("/")
    public String homeLoginV4(@SessionAttribute(name = SessionConst.LOGIN_MEMBER, required = false) Member loginMember, Model model) {

        // @SessionAttribute에서 session이 null인지, SessionConst.LOGIN_MEMBER 이름을 가진 java 객체 값이 session에 존재하는지 확인해준다.
        // 세션에 회원 데이터가 없으면 home
        if (loginMember == null) {
            return "home";
        }

        model.addAttribute("member", loginMember);
        return "loginHome";
    }
}