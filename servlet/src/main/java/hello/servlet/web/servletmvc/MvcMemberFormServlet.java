package hello.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet { // Controller 역할

    // servlet = controller, jsp = view로 생각한다.
    // MVC 패턴에서는 Controller를 거쳐서 View로 가야한다.

    // 고객 요청이 오면 service가 호출된다.
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath); // getRequestDispatcher() : controller에서 View로 이동할 때 사용
        dispatcher.forward(request, response); // servlet에서 JSP 호출
    }
}
