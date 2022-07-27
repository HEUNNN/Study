package restfulAPI.webservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
    // 예외처리를 위해 사용되는 Java 객체이다.
    private Date timeStamp; // 예외 발생 시간
    private String message;
    private String details; // 예외의 상태 정보
}
