package hello.login.web.session;

import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 세션 관리
 */
@Component
public class SessionManager {

    private Map<String, Object> sessionStore = new ConcurrentHashMap<>(); // 동시성 이유 방지를 위해 ConcurrentHashMap 사용
    public static final String SESSION_COOKIE_NAME = "mySessionId";

    /*
     * 세션 생성 로직
     * * sessionId 생성 (임의의 추정 불가능한 랜덤 값)
     * * 세션 저장소에 sessionId와 보관할 값 저장
     * * sessionId로 응답 쿠키를 만들어서 클라이언트에 응답으로 전달
     * */
    public void createSession(Object value, HttpServletResponse response) {

        // 세션 id를 생성하고, 값을 세션에 저장
        String sessionId = UUID.randomUUID().toString();
        sessionStore.put(sessionId, value);

        // 세션ID 값을 담은 쿠키 생성
        Cookie mySessionCookie = new Cookie(SESSION_COOKIE_NAME, sessionId); // 세션아이디가 담긴 쿠키의 이름은 SESSION_COOKIE_NAME 즉, mySessionId 이다. value는 sessionId가 담겨있다.
        response.addCookie(mySessionCookie);
    }

    /*
     * 세션 조회
     * */
    public Object getSession(HttpServletRequest request) {
        Cookie sessionCookie = findCookie(request, SESSION_COOKIE_NAME);
        if (sessionCookie == null) {
            return null;
        }
        return sessionStore.get(sessionCookie.getValue()); // sessionCookie는 sessionId value를 갖고 있고, sessionStore에는 sessionId 값에 해당하는 object(ex. memberA)를 갖고 있다.
    }

    /*
     * 세션 만료
     * */

    public void expire(HttpServletRequest request) {
        Cookie sessionCookie = findCookie(request, SESSION_COOKIE_NAME); // 만료시킬 세션쿠키
        if (sessionCookie != null) {
            sessionStore.remove(sessionCookie.getValue());
        }
    }

    public Cookie findCookie(HttpServletRequest request, String cookieName) {
        if (request.getCookies() == null) {
            return null;
        }
        Cookie findCokkieValue = Arrays.stream(request.getCookies())
                .filter(cookie -> cookie.getName().equals(cookieName))
                .findAny()
                .orElse(null);

        return findCokkieValue;
    }

}
