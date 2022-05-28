package hello.springmvc.basic.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {

    @GetMapping
    public String user() {
        return "get user list";
    }

    @PostMapping
    public String addUser() {
        return "post user";
    }

    @GetMapping("/{userId}")
    public String findUser() {
        return "get findUses ";
    }

    @PatchMapping("/{userId}")
    public String modifyUser() {
        return "patch modify user";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser() {
        return "delete user";
    }

}
