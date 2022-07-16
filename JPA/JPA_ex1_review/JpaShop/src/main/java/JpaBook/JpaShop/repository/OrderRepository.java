package JpaBook.JpaShop.repository;

import JpaBook.JpaShop.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final EntityManager em;

    public void save(Order order) {
        em.persist(order);
    }

    public Order findOne(Long id) {
        Order findOrder = em.find(Order.class, id);
        return findOrder;
    }

    // 검색을 위한 reposiotry 기능
//    public List<Order> findAl(OrderSearch orderSearch) {}
}
