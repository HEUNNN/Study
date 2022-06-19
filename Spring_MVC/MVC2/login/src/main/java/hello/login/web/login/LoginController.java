package hello.login.web.login;

import hello.login.domain.login.LoginService;
import hello.login.domain.member.Member;
import hello.login.web.SessionConst;
import hello.login.web.session.SessionManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;
    private final SessionManager sessionManager; // sessionManager DI(의존성 주입)

    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") LoginForm loginForm) { // HTML form 형태의 HTTP 요청 파라미터 데이터를 @ModelAttribute를 사용하여 LoginForm에 매핑하다.
        return "login/loginForm";
    }

    //    @PostMapping("/login")
    // session을 적용하지 않고, cookie만 사용했다.
    public String loginV1(@Valid @ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult, HttpServletResponse response) {
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

    // SessionManager 적용하기
//    @PostMapping("/login")
    public String loginV2(@Valid @ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult, HttpServletResponse response) {
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
        // sessionManager를 통해 세션을 생성하고, 회원 데이터를 보관
        sessionManager.createSession(loginMember, response);


        return "redirect:/";
    }

    //    @PostMapping("/login")
    public String loginV3(@Valid @ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult, HttpServletRequest request) {
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
        // 서블릿 HTTP 세션 사용 → HttpServletRequest 필요
        HttpSession session = request.getSession(); // 세션이 있으면 있는 세션을 반환하고, 없으면 신규 세션을 반환한다.
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember); // 세션에 로그인 회원 정보 보관


        return "redirect:/";
    }

    @PostMapping("/login")
    public String loginV4(@Valid @ModelAttribute("loginForm") LoginForm loginForm, BindingResult bindingResult,
                          HttpServletRequest request, @RequestParam(defaultValue = "/") String redirectURL) {
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
        // 서블릿 HTTP 세션 사용 → HttpServletRequest 필요
        HttpSession session = request.getSession(); // 세션이 있으면 있는 세션을 반환하고, 없으면 신규 세션을 반환한다.
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember); // 세션에 로그인 회원 정보 보관


        return "redirect:" + redirectURL;
    }

    //    @PostMapping("/logout") // loginHome.html에 보면 logout 버튼의 form의 method가 post 방식의 HTTP 요청을 보내온다.
    public String logoutV1(HttpServletResponse response) {
        expireCookie(response, "memberId");
        return "redirect:/";
    }

    //    @PostMapping("/logout")
    public String logoutV2(HttpServletRequest request) {
        sessionManager.expire(request);
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logoutV3(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }

    private void expireCookie(HttpServletResponse response, String cookieName) {
        Cookie cookie = new Cookie(cookieName, null);
        cookie.setMaxAge(0); // 만료시킨 쿠키
        response.addCookie(cookie);
    }
}
