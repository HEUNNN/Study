package restfulAPI.webservice.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restfulAPI.webservice.domain.User;
import restfulAPI.webservice.exception.UserNotFoundException;
import restfulAPI.webservice.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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

    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isEmpty()) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }
        // HATEOAS
        EntityModel<User> model = EntityModel.of(userOpt.get());
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers()); // 위에 생성한 retrieveAllUsers 메서드
        model.add(linkTo.withRel("all-users"));
        return model;
    }

    @PostConstruct
    public void init() {
        userRepository.save(new User(1, "user1", new Date(), "pass1", "111111"));
        userRepository.save(new User(2, "user2", new Date(), "pass2", "222222"));
        userRepository.save(new User(3, "user3", new Date(), "pass3", "333333"));
    }
}
