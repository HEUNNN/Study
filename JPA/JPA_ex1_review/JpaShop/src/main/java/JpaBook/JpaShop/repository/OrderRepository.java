package JpaBook.JpaShop.repository;

import JpaBook.JpaShop.domain.Member;
import JpaBook.JpaShop.domain.Order;
import JpaBook.JpaShop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.thymeleaf.model.IStandaloneElementTag;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
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
    // 동적 쿼리를 만드는 방식에는 JPQL(그냥 String), Criteria, QueryDSL 이 있다.

    public List<Order> findAllByCriteria(OrderSearch orderSearch) {

        // 검색 로직

        // 정적 쿼리
        // DB에서 조회하여 order 엔티티 객체를 만들고, order와 멤버를 조인한것을 om이라 하는 JPQL이다.
        /*
        List<Order> resultList = em.createQuery("select o from Order o join o.memeber om"
                        + " where o.status = :status"
                        + " and om.name like :name", Order.class)
                .setParameter("status", orderSearch.getOrderStatus())
                .setParameter("name", orderSearch.getMemberName())
                .setMaxResults(1000)
                .getResultList();
        */

        // 만약 orderSearch에 memberName, OrderStatus가 없으면 where o.status = :status와 같이 파라미터를 사용하면 안된다.
        // OrderSearch 파라미터에 따라 쿼리가 달라지는 동적 쿼리가 되어야 한다.

        // 동적 쿼리 1 → 동적쿼리를 문자로 작성하는 방법, 실무에서 사용하지 않는 방법
        /*
        String jpql = "select o from order o join o.member om";
        boolean isFirstCondition = true;

        // 주문 상태 검색
        if (orderSearch.getOrderStatus() != null) {
            if (isFirstCondition) {
                jpql += " where";
                isFirstCondition = false;
            } else {
                jpql += " and";
            }
            jpql += " o.status = :status";
        }

        // 회원 이름 검색
        if (StringUtils.hasText(orderSearch.getMemberName())) {

            if (isFirstCondition) {
                jpql += " where";
                isFirstCondition = false;
            } else {
                jpql += " and";
            }
            jpql += " om.name like :name";
        }


        TypedQuery<Order> query = em.createQuery(jpql, Order.class)
                .setMaxResults(1000);

        if (orderSearch.getOrderStatus() != null) {
            query = query.setParameter("status", orderSearch.getOrderStatus());
        }
        if (StringUtils.hasText(orderSearch.getMemberName())) {
            query = query.setParameter("name", orderSearch.getMemberName());
        }

        return query.getResultList();
        */

        // 동적 쿼리 2 → criteria 사용, 별로 권장하는 방법은 아니다. 유지 보수성이 매우 낮은 단점이 있다.
        // criteria: JPA가 제공해주는 동적쿼리로 작성하기 위해 jpql을 자바 코드로 작성할 수 있게 해준 표준

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Order> cq = cb.createQuery(Order.class);

        Root<Order> root = cq.from(Order.class); // 시작지점
        Join<Object, Member> om = root.join("member", JoinType.INNER);

        List<Predicate> criteria = new ArrayList<>();

        // 주문 상태 검색
        if (orderSearch.getOrderStatus() != null) {
            Predicate status = cb.equal(root.get("status"), orderSearch.getOrderStatus());
            criteria.add(status);
        }

        // 회원 이름 검색
        if (StringUtils.hasText(orderSearch.getMemberName())) {
            Predicate name = cb.like(om.<String>get("name"), "%" + orderSearch.getMemberName() + "%");
            criteria.add(name);
        }


        cq.where(cb.and(criteria.toArray(new Predicate[criteria.size()])));
        TypedQuery<Order> query = em.createQuery(cq).setMaxResults(1000);

        return query.getResultList();
    }
    // 쿼리 DSL을 사용하여 동적 쿼리 생성
}
