package restfulAPI.webservice.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lombok.RequiredArgsConstructor;
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

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminUserController {

    private final UserDaoService userDaoService; // 의존성 주입

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public MappingJacksonValue retrieveUser(@PathVariable("id") int userId) throws UserNotFoundException {
        User findUser = userDaoService.findOne(userId);

        // 존재하지 않는 userId가 PathVariable로 넘어온 경우 예외를 발생시켜 Response 응답에 나타내기
        if (findUser == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", userId));
        }

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "joinDate", "password", "ssn");

        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", (filter));
        MappingJacksonValue mapping = new MappingJacksonValue(findUser);
        mapping.setFilters(filters);

        return mapping;
    }

}
