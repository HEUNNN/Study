package restfulAPI.webservice.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import restfulAPI.webservice.domain.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Service // @Component가 포함되어 있음
public class UserDaoService {

    public static List<User> users = new ArrayList<>(); // DB를 아직 연결하여 사용하지 않기 때문에 Collection 을 선언하여 User 객체들을 저장한다.

    private static int userCount = 3;

    static {
        users.add(new User(1, "Kenneth", new Date()));
        users.add(new User(2, "Alice", new Date()));
        users.add(new User(3, "Elena", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++userCount);
        }
        if (user.getJoinDate() == null) {
            user.setJoinDate(new Date());
        }
        users.add(user);
        userCount++;
        return user;
    }

    public User findOne(int userId) {

        for (User user : users) {
            if (user.getId() == userId) {
                return user;
            }
        }

        // userId를 갖는 user 객체가 없는 경우
        return null;
    }

    public User deleteById(int userId) {
        for(User user : users) {
            if (user.getId() == userId) {
                users.remove(user);
                return user;
            }
        }
        return null;
    }
}
