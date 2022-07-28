package restfulAPI.webservice.domain;

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
public class User {

    @NotNull
    private Integer id;

    @NotNull
    @Size(min = 2, max = 10, message = "Name은 2글자 이상 10글자 이하로 입력해주세요.")
    private String name;

    @Past // 과거 데이터만 사용할 수 있다는 validation 조건 걸어준다.
    private Date joinDate;
}
