package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {
    // ControllerV3를 지원하는 어댑터
    @Override
    public boolean support(Object handler) { // 핸들러는 ControllerV3, ControllerV4 등과 같은 컨트롤러라고 보면된다.
        return (handler instanceof ControllerV3);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {

        ControllerV3 controller = (ControllerV3) handler; // Object type에서 ControllerV3로 캐스팅(type 변환)
        // ControllerV3는 ModelView를 반환하는 컨트롤러이다.
        Map<String, String> paramMap = createParamMap(request);
        ModelView modleView = controller.process(paramMap);// 전달받은 paramMap을 갖고 로직을 수행하여 얻은 데이터(memberList, savedMember 등등)들을 ModelView 객체의 model에 넣고 그 ModelView 인스턴스를 반환한다.
        return modleView;

    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));

        return paramMap;
    }
}
