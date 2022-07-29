package restfulAPI.webservice.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import restfulAPI.webservice.domain.User;
import restfulAPI.webservice.dto.UserEditDto;
import restfulAPI.webservice.exception.UserNotFoundException;
import restfulAPI.webservice.service.UserDaoService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserDaoService userDaoService; // 의존성 주입

    @GetMapping("/users")
    public MappingJacksonValue retrieveAllUsers() {

        List<User> users = userDaoService.findAll();

        //=== Filtering ===//
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate");

        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", (filter));
        MappingJacksonValue mapping = new MappingJacksonValue(users);
        mapping.setFilters(filters);

        return mapping;
    }

    @GetMapping("/users/{id}")
    public MappingJacksonValue retrieveUser(@PathVariable("id") int userId) throws UserNotFoundException {
        User findUser = userDaoService.findOne(userId);

        // 존재하지 않는 userId가 PathVariable로 넘어온 경우 예외를 발생시켜 Response 응답에 나타내기
        if (findUser == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", userId));
        }

        // HATEOAS 적용
        EntityModel<User> model = EntityModel.of(findUser); // EntityModel은 protected라 바로 사용할 수 없어 이렇게 사용한다.
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers()); // linkTo, methodOn import 해서 사용
        model.add(linkTo.withRel("all-users")); //linkTo와 URI 값을 연결 시켜서 model에 넣어준다.

        // HATEOAS를 적용한 EntityModel<User> model을 filtering 해서 반환한다.
        /*
         * MappingJacksonValue로 반환하되, MappingJacksonValue를 생성하는 파라미터로 user데이터가 아닌,
         * Resource<User>가 전달되면 filter된 값과 hateoas가 추가된 형태의 반환 값이 전달될 것입니다.
         */

        //=== Filtering ===//
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate");

        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", (filter));
        MappingJacksonValue mapping = new MappingJacksonValue(model);
        mapping.setFilters(filters);

        return mapping;
    }

    @PostMapping("/users") // user 객체 service 의 users list 에 저장하기
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) { // @RequestBody 는 HTTP 요청 '메시지' 바디에 있는 내용을 조회하는 애노테이션이다.
        User savedUser = userDaoService.save(user);

        // HTTP 요청 메시지는
        // HTTP 요청 파라미터(쿼리파라미터, HTML Form 에서 넘어오는 데이터 등)와 다르다.

        // POST MAN 에서
        //{
        //    "id": 4,
        //    "name": "Apple",
        //    "joinDate": "2022-07-26T05:13:55.311+00:00"
        //} 를 POST 방식으로 보내면 된다.

        // 사용자에게 HTTP Response 를 보낼 때 적절한 status code 를 보내기 위한 코드
        // 원래 200 OK 였는데, 201 Created 로 바뀐다.
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()) // savedUser 의 id를 .path("/{id}")에 넣어준다.
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") int userId) {
        User deletedUser = userDaoService.deleteById(userId);
        if (deletedUser == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", userId));
        }
    }

    @PutMapping("/users/{id}")
    public void editUserName(@PathVariable("id") int userId, @Valid @RequestBody UserEditDto editDto) {
        // @RequestBody는 JSON으로 넘어오는 HTTP 요청 메시지 바디 내용을 Java 객체와 매핑해준다.
        String userName = editDto.getName();
        User editUser = userDaoService.editById(userId, userName);
        if (editUser == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", userId));
        }
    }
}
