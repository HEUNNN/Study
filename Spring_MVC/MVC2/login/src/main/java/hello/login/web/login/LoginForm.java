package hello.login.web.login;


import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class LoginForm {  // domain의 Member와 같은 역할

    @NotEmpty
    private String loginId;
    @NotEmpty
    private String password;
}
