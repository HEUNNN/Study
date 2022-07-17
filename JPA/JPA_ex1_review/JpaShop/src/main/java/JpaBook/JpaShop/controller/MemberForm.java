package JpaBook.JpaShop.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotEmpty;

@Slf4j
@Getter
@Setter
public class MemberForm {

    // 회원 가입 화면에 적합한 도메인을 따로 만들었다.
    @NotEmpty(message = "회원 이름은 필수입니다.")
    public String name;

    public String city;
    public String street;
    public String zipcode;
}
