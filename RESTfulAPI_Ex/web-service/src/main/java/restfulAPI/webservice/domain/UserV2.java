package restfulAPI.webservice.domain;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("UserInfoV2")
public class UserV2 extends User { // UserV2가 User을 상속받을 때, User에 default 생성자가 있어야한다. + UserV2에도 default 생성자가 필요하다.

    private String grade;
}
