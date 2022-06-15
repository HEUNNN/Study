package hello.login.domain.member;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data // Lombok
public class Member {
    private Long id;

    @NotEmpty // Bean Validation
    private String loginId;

    @NotEmpty
    private String name;

    @NotEmpty
    private String password;
}
