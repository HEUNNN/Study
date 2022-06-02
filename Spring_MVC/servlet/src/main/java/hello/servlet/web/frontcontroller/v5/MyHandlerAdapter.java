package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;
import org.springframework.ui.Model;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {
    boolean support(Object handler); // handler(사용하고자하는 특정 Controller)를 이 어댑터가 처리할 수 있는지에 대해 true or false를 반환한다.
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;

    /*
    * 어댑터는 실제 컨트롤러를 호출하고, 그 결과로 ModelView를 반환받아야한다.
    * 실제 컨트롤러가 ModelView를 반환하지 못하면, 어댑터가 ModelView를 직접 생성해서라도 반환해야한다.
    * 이전에는 프론트 컨트롤러가 실제 컨트롤러를 호출했지만, 이제는 이 어댑터를 통해서 실제 컨트롤러가 호출된다.
    * */

}
