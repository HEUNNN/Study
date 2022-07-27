package restfulAPI.webservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import restfulAPI.webservice.domain.User;
import restfulAPI.webservice.service.UserDaoService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserDaoService userDaoService; // 의존성 주입

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable("id") int userId) {
        User findUser = userDaoService.findOne(userId);
        return findUser;
    }

    @PostMapping("/users") // user 객체 service 의 users list 에 저장하기
    public void createUser(@RequestBody User user) { // @RequestBody는 HTTP 요청 '메시지' 바디에 있는 내용을 조회하는 애노테이션이다.
        User savedUser = userDaoService.save(user);

        // HTTP 요청 메시지는
        // HTTP 요청 파라미터(쿼리파라미터, HTML Form에서 넘어오는 데이터 등)와 다르다.

        // POST MAN에서
        //{
        //    "id": 4,
        //    "name": "Apple",
        //    "joinDate": "2022-07-26T05:13:55.311+00:00"
        //} 를 POST 방식으로 보내면 된다.
    }
}
