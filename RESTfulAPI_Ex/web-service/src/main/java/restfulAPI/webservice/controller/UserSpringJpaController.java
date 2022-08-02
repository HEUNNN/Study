package restfulAPI.webservice.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restfulAPI.webservice.domain.User;
import restfulAPI.webservice.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/jpa")
public class UserSpringJpaController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }
    @PostConstruct
    public void init() {
        userRepository.save(new User(1, "user1", new Date(), "pass1", "111111"));
        userRepository.save(new User(2, "user2", new Date(), "pass2", "222222"));
        userRepository.save(new User(3, "user3", new Date(), "pass3", "333333"));
    }
}
