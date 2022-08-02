package restfulAPI.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restfulAPI.webservice.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
