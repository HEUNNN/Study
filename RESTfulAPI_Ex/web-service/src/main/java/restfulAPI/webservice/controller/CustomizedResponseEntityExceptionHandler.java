package restfulAPI.webservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import restfulAPI.webservice.exception.ExceptionResponse;
import restfulAPI.webservice.exception.UserNotFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@ControllerAdvice // 모든 컨트롤러가 실행되기 전 @ControllerAdvice가 붙은 빈이 먼저 실행되도록 한다.
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    // AOP 기능을 사용
    @ExceptionHandler(Exception.class) // 어떤 예외를 처리할 것인지를 명시해준다.
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

        // request.getDescription을 false로 했기 때문에 UserNotFoundException이 발생해도 HTTP response에 적혀있는 에러 정보가 간단해진다.
    }

    // UserNotFoundException 전용 예외처리 메서드
    @ExceptionHandler(UserNotFoundException.class) // 어떤 예외를 처리할 것인지를 명시해준다.
    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, HttpServletRequest request) {
        String requestURI = request.getRequestURI();

        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), String.format("uri=%s", requestURI));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);

        // request.getDescription을 false로 했기 때문에 UserNotFoundException이 발생해도 HTTP response에 적혀있는 에러 정보가 간단해진다.
    }
}
