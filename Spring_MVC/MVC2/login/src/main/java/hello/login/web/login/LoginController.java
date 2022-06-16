package hello.login.web.login;

import hello.login.domain.login.LoginService;
import hello.login.domain.member.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm loginForm) { // HTML form 형태의 HTTP 요청 파라미터 데이터를 @ModelAttribute를 사용하여 LoginForm에 매핑하다.
        return "login/loginForm";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult, HttpServletResponse response) {
        if (bindingResult.hasErrors()) { // 특정 필드의 문제가 아니다. 글로벌 오류이다.
            return "login/loginForm";
        }

        Member loginMember = loginService.login(loginForm.getLoginId(), loginForm.getPassword());

        log.info("login ? {}", loginMember);

        if (loginMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞기 않습니다.");
            return "login/loginForm";
        }

        // 로그인 성공 처리

        // 로그인에 성공하면 idCookie 를 응답에 넣어서 client에게 보낸다.
        // 쿠키에 시간 정보를 주지 않으면 세션쿠키로 인식된다. 세션 쿠키는 브라우저 종료시 모두 종료된다.
        // idCookie는 loginId값이 아닌 memberId 라는 이름으로 id 값을 넘긴다.
        Cookie idCookie = new Cookie("memberId", String.valueOf(loginMember.getId())); // long 타입인 id 값을 String.valueOf()를 사용하여 String 타입으로 변환한다.
        response.addCookie(idCookie);

        return "redirect:/";
    }

    @PostMapping("/logout") // loginHome.html에 보면 logout 버튼의 form의 method가 post 방식의 HTTP 요청을 보내온다.
    public String logout(HttpServletResponse response) {
        expireCookie(response, "memberId");
        return "redirect:/";
    }

    private void expireCookie(HttpServletResponse response, String cookieName) {
        Cookie cookie = new Cookie(cookieName, null);
        cookie.setMaxAge(0); // 만료시킨 쿠키
        response.addCookie(cookie);
    }
}
