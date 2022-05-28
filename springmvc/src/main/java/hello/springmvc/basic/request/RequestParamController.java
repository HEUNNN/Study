package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username = {}, age = {}", username, age);

        response.getWriter().write("ok");
    }

    @ResponseBody // View 조회를 무시하고, HTTP message body에 직접 해당 내용 입력
    @RequestMapping("/request-param-v2")
    public String requestParamV2(@RequestParam("username") String memberName,
                                 @RequestParam("age") int memberAge) {
        log.info("memberName = {}, memberAge = {}", memberName, memberAge);
        return "ok";
    }

    // HTTP 파라미터 이름이 변수 이름과 같으면 @RequestParam(name="XX") 생략 가능
    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(@RequestParam String username,
                                 @RequestParam int age) {
        log.info("memberName = {}, memberAge = {}", username, age);
        return "ok";
    }

    // String, int 등의 단순 타입이면 @RequestParam도 생략 가능
    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age) {
        log.info("memberName = {}, memberAge = {}", username, age);
        return "ok";
    }


    // query parameter 로 username이 꼭 들어와야 한다.
    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(@RequestParam(required = true) String username, @RequestParam(required = false) Integer age) { // age값을 안넘기면 int는 null을 받을 수 없지만, Integer는 객체라서 null을 받을 수 있다.
        log.info("memberName = {}, memberAge = {}", username, age);
        return "ok";
    }

    // 파라미터에 값이 없는 경우 defaultValue를 지정하여 기본 값을 적용한다.
    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(@RequestParam(required = true, defaultValue = "guest") String username, @RequestParam(required = false, defaultValue = "-1") Integer age) {
        log.info("memberName = {}, memberAge = {}", username, age);
        return "ok";
    }

    // 파라미터를 Map으로 조회하기 -> MultiValueMap도 가능하다
    @ResponseBody
    @RequestMapping("request-param-map")
    public String requestParamMap(@RequestParam Map<String , Object> paramMap) {
        log.info("memberName = {}, memberAge = {}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }

}
