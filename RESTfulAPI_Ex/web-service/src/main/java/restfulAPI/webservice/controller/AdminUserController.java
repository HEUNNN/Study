package restfulAPI.webservice.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import restfulAPI.webservice.domain.User;
import restfulAPI.webservice.domain.UserV2;
import restfulAPI.webservice.exception.UserNotFoundException;
import restfulAPI.webservice.service.UserDaoService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminUserController {

    private final UserDaoService userDaoService; // 의존성 주입

    @GetMapping("/users")
    public MappingJacksonValue retrieveAllUsers() {

        List<User> users = userDaoService.findAll();

        //=== Filtering ===//
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate", "password", "ssn");

        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", (filter));
        MappingJacksonValue mapping = new MappingJacksonValue(users);
        mapping.setFilters(filters);

        return mapping;
    }

    // version 관리
//    @GetMapping("/v1/users/{id}") // URI를 사용하여 version관리
//    @GetMapping(value = "/users/{id}/", params = "version=1") /// Request Parameter를 이용한 API version 관리
    @GetMapping(value = "/users/{id}", headers = "X-API-VERSION=1") // headers를 이용한 API version 관리
    public MappingJacksonValue retrieveUserV1(@PathVariable("id") int userId) throws UserNotFoundException {
        User findUser = userDaoService.findOne(userId);

        // 존재하지 않는 userId가 PathVariable로 넘어온 경우 예외를 발생시켜 Response 응답에 나타내기
        if (findUser == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", userId));
        }

        //=== Filtering ===//
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate", "password", "ssn");

        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", (filter));
        MappingJacksonValue mapping = new MappingJacksonValue(findUser);
        mapping.setFilters(filters);

        return mapping;
    }

    //    @GetMapping("/v2/users/{id}") // URI를 사용하여 version 관리
//    @GetMapping(value = "/users/{id}/", params = "version=2") // Request Parameter를 이용한 API version 관리
    @GetMapping(value = "/users/{id}", headers = "X-API-VERSION=2") // headers를 이용한 API version 관리
    public MappingJacksonValue retrieveUserV2(@PathVariable("id") int userId) throws UserNotFoundException {
        User findUser = userDaoService.findOne(userId);

        // 존재하지 않는 userId가 PathVariable로 넘어온 경우 예외를 발생시켜 Response 응답에 나타내기
        if (findUser == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", userId));
        }

        // original인 User를 UserV2로 변환시키기
        UserV2 userV2 = new UserV2();
        BeanUtils.copyProperties(findUser, userV2);
        userV2.setGrade("VIP");

        //=== Filtering ===//
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate", "grade", "password", "ssn");

        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfoV2", (filter));
        MappingJacksonValue mapping = new MappingJacksonValue(userV2);
        mapping.setFilters(filters);

        return mapping;
    }

}
