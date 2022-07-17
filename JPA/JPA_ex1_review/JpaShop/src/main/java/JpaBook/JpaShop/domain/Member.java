package JpaBook.JpaShop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    // Order 테이블에 있는 member 필드에 의해 매핑되었다는 것을 의미한다. 읽기 전용으로 이곳에서 order 값을 변경해도 Order 테이블의 FK인 member_id가 변하지 않는다.
    private List<Order> orders = new ArrayList<>();
}
