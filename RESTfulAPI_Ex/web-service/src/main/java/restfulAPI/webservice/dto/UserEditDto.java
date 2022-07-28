package restfulAPI.webservice.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NotNull
public class UserEditDto {
    @Size(min = 2, max = 10)
    String name;
}
