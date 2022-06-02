package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 { // servlet 기술을 사용하지 않음
    ModelView process(Map<String, String> paraMap);
}
