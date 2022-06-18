package hello.login.web.session;

import hello.login.domain.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.assertj.core.api.Assertions.*;

public class SessionManagerTest {
    SessionManager sessionManager = new SessionManager();

    @Test
    void sessionTest() {
        // 세션 생성
        MockHttpServletResponse response = new MockHttpServletResponse();
        Member member = new Member();
        sessionManager.createSession(member, response); // sessionId와 member 값을 짝 지어서 sessionStore에 저장하고, sessionId를 담은 쿠키를 새로 생성하여 response에 담아서 보낸다.

        // 요청에 응답 쿠키 저장
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setCookies(response.getCookies());

        // 세션 조회
        Object result = sessionManager.getSession(request); // request에 담겨있는 sessionIdCookie를 갖고, sessionStore에서 해당 sessionId에 해당하는 Object를 반환한다.
        assertThat(result).isEqualTo(member);

        // 세션 만료
        sessionManager.expire(request); // 이 request에 SESSION_COOKIE_NAME 이름을 갖는 sessionId 관련 쿠키를 찾아서 remove 해준다.
        Object expired = sessionManager.getSession(request);
        assertThat(expired).isNull();
    }
}
