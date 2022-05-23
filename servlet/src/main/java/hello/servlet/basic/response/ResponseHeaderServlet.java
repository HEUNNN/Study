package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // [status-line]
        response.setStatus(HttpServletResponse.SC_OK); // HTTP 응답 코드가 200 이라는 의미, 200인 response를 응답해줌

        // [response-header]
        response.setHeader("Content-type", "text/pain;charset=utf-8"); // 직접 설정하는 것이 번거로우니 Content 편ㅇ의 메서드를 사용
        // response.setContentType("text/plain");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header", "helloooooo"); // 내가 정한 임의의 헤더도 만들 수 있다.

        PrintWriter writer = response.getWriter();
        writer.println("ok");

        // [Header 편의 메서드]
        content(response);
        cookie(response);
        redirect(response);

        // [message body]
        PrintWriter pw = response.getWriter();
        pw.write("ok!!");


    }
    private void content(HttpServletResponse response) {
        // Content 편의 메서드

        // Content-type: text/plain;charset=utf-8
        // Content-length: 2
        // response.setHeader("Content-Type", "text/plain;charset=utf-8"); // 헤더의 Content 관련 값을 직접 설정하지 않아도 된다.
        response.setContentType("text/pain");
        response.setCharacterEncoding("utf-8");
        // response.setContentLength(2); // 생략시 자동 생성
    }

    private void cookie(HttpServletResponse response) {
        // Cookie 편의 메서드

        // Set-Cookie: myCookie=good; Max-Age=600; 로 설정하려면 아래와 같이 직접 설정하거나 Cookie 인스턴스를를 사용하여 좀 더 간편하게 설정할 수 있다.
        // response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600);
        response.addCookie(cookie);
    }

    private void redirect(HttpServletResponse response) throws IOException {
        // Redirect 편의 메서드

        // Status Code 302
        // Location: /basic/hello-form.html

        // response.setStatus(HttpServletResponse.SC_FOUND); // 302
        // response.setHeader("Location", "/basic/hello-form.html");
        response.sendRedirect("/basic/hello-form.html");
    }

}
