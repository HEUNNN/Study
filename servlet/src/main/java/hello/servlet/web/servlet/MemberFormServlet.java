package hello.servlet.web.servlet;

import hello.servlet.domain.member.MemberRespository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "memberFormServlet", urlPatterns = "/servlet/members/new-form") // 회원 등록용 HTML폼을 서블릿을 통해 볼 수 있다.
public class MemberFormServlet extends HttpServlet {
    private MemberRespository memberRespository = MemberRespository.getInstance(); // Singlton 유지

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter w = response.getWriter();
        // /servlet/members/new-form url로 접속하면 servlet이 아래와 같은 응답을 바디에 넣어서 내려주면 web은 html을 해석하여 사용자에게 입력 폼을 보여준다.
        // 그 form에서 username, age를 입력하여 전송 버튼을 누르면 /servlet/members/save 로 POST 요청을 보낸다.
        w.write("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form action=\"/servlet/members/save\" method=\"post\">\n" +
                "    username: <input type=\"text\" name=\"username\" />\n" +
                "    age:      <input type=\"text\" name=\"age\" />\n" +
                " <button type=\"submit\">전송</button>\n" + "</form>\n" +
                "</body>\n" +
                "</html>\n");

    }
}
