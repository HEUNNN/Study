package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import hello.servlet.web.frontcontroller.v5.adapter.ControllerV3HandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {

    // 핸들러(컨트롤러) 매핑 정보
    private final Map<String, Object> handlerMappingMap = new HashMap<>(); // Object 타입으로 하여 아무 컨트롤러(ControllerV1, ControllerV2 .. 등등)를 받을 수 있다.
    // 핸들러를 다루는 어댑터 매핑 정보
    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerServletV5() { // 생성할 때 handlerMappingMap, handlerAdapter 등을 채운다.
        initHandlerMappingMap();
        initHandlerAdapters();
    }

    private void initHandlerAdapters() {
        handlerAdapters.add(new ControllerV3HandlerAdapter()); // ControllerV3HandlerAdapter가 구현한 인터페이스는 MyHandlerAdapter이다.
    }

    private void initHandlerMappingMap() {
        handlerMappingMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object handler = getHandler(request);

        if (handler == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyHandlerAdapter adapter = getHandlerAdapter(handler);
        ModelView modelView = adapter.handle(request, response, handler); // adapter가 controller(handle)에 접근하여 로직을 처리한 값을 model에 담은 modelView를 반환해준다.
        MyView myView = viewResolver(modelView.getViewName());
        myView.render(modelView.getModel(), request, response);
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    // refactoring
    private MyHandlerAdapter getHandlerAdapter(Object handler) {
        MyHandlerAdapter handlerAdapter;
        for (MyHandlerAdapter adapter : handlerAdapters) {
            if (adapter.support(handler)) {
                return adapter;
            }
        }
        throw new IllegalStateException("handlerAdapter를 찾을 수 없습니다. handler = " + handler );
    }

    private Object getHandler(HttpServletRequest request) { // 핸들러 매핑 정보에서 핸들러 조회
        String requestURI = request.getRequestURI();
        return handlerMappingMap.get(requestURI); // ControllerAdapter에서 특정 컨트롤러(핸들)에 맞는 type으로 casting해준다.
    }
}
