package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello") // "/hello"가 들어오면 해당 HelloServlet이 실행된다.
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 해당 서블릿이 호출되면 service method가 호출된다.
        System.out.println("HelloServlet.service"); // 단축키 soutm
        System.out.println("request = " + request); // 단축키  soutv
        System.out.println("response = " + response);

        // 쿼리 파라미터 read
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        // response에 데이터 담아 보내기 (HTTP response message)
        response.setContentType("text/plain"); // HTTP message header의 content-type에 들어가는 정보
        request.setCharacterEncoding("utf-8"); // HTTP message header의 content-type에 들어가는 정보
        response.getWriter().write("Hello " + username); // HTTP message body에 내용을 넣는 메서드

    }
}

