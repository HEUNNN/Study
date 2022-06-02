package hello.servlet.web.servlet;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "memberSaveServlet", urlPatterns = "/servlet/members/save")
public class MemberSaveServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // /servlet/members/new-form에서 form의 버튼을 누르면 /servlet/members/save로 request를 보낸다.
        // 이 요청에서 username, age를 꺼내서 Member 인스턴스를 생성하고 memberRepository에 저장한다.
        // Member 인스턴스에서 id, username, age 등을 포함한 html을 response로 웹에 내려준다.
        String username = request.getParameter("username"); // request.getParameter()의 반환 값은 항상 String
        int age = Integer.parseInt(request.getParameter("age"));

        // save
        Member member = new Member(username, age);
        memberRepository.save(member);

        // save된 내용 확인 → web에 html 응답으로 내려보냄
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter w = response.getWriter();
        // 동적인 HTML → member.getId()와 같은 코드가 동적인 HTML을 만들어준다.
        w.write("<html>\n" +
                "<head>\n" +
                " <meta charset=\"UTF-8\">\n" + "</head>\n" +
                "<body>\n" +
                "성공\n" +
                "<ul>\n" +
                "    <li>id=" + member.getId() + "</li>\n" +
                "    <li>username=" + member.getUsername() + "</li>\n" +
                " <li>age=" + member.getAge() + "</li>\n" + "</ul>\n" +
                "<a href=\"/index.html\">메인</a>\n" + "</body>\n" +
                "</html>");

    }
}
