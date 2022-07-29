package restfulAPI.webservice.domain;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value = {"password", "ssn"})
@JsonFilter("UserInfo")
public class User {

    @NotNull
    private Integer id;

    @NotNull
    @Size(min = 2, max = 10, message = "Name은 2글자 이상 10글자 이하로 입력해주세요.")
    private String name;

    @Past // 과거 데이터만 사용할 수 있다는 validation 조건 걸어준다.
    private Date joinDate;

    // 중요한 필드라서 cliend가 원본을 확인할 수 없도록 해야한다.
//    @JsonIgnore // 해당 데이터 값을 숨겨서 응답으로 client에게 보여준다.(필드 명도 숨긴다.) + class level에도 붙일 수 있다.
    private String password;

//    @JsonIgnore
    private String ssn;
}
