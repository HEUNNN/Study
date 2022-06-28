package hello.exception.api;

import hello.exception.exception.UserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static hello.exception.api.ApiExceptionController.*;

@Slf4j
@RestController
public class ApiExceptionControllerV2 {

    // ControllerAdvice를 사용하여 예외를 처리하는 부분을 분리함
    @GetMapping("/api2/members/{id}")
    public MemberDto getMember(@PathVariable("id") String id) {
        if (id.equals("ex")) {
            throw new RuntimeException("잘못된 사용자");
        }

        if (id.equals("bad")) {
            throw new IllegalArgumentException("잘못된 입력 값");
        }

        if (id.equals("user-ex")) {
            throw new UserException("사용자 오류");
        }

        return new MemberDto(id, "hello" + id);
    }


}
