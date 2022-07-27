package restfulAPI.webservice.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import restfulAPI.webservice.domain.User;

import java.util.List;

@SpringBootTest
class UserDaoServiceTest {
    private UserDaoService userDaoService = new UserDaoService();

    @Test
    public void deleteById() {
        User deleteUser = userDaoService.deleteById(10);
        System.out.println(deleteUser);
        List<User> users = userDaoService.findAll();
        for (User user : users) {
            System.out.println(user.getName());
        }
    }

}