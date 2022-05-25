package hello.servlet.web.frontcontroller.v4;

import java.util.Map;

public interface ControllerV4 {
    String process(Map<String,String> paramMap, Map<String, Object> model);
    // paramMap은 String key는 username or age이고, String value는 "lee", "kim", 20, 21.. 등과 같은 이름 or 나이 value이다.
    // Map<String, Object> model에는 MemberRepository에 저장한 member 인스턴스 혹은 findAll()을 통해 찾은 members 등을 담는 model이다.
}
