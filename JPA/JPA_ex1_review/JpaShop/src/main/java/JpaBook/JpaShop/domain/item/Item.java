package JpaBook.JpaShop.domain.item;

import JpaBook.JpaShop.domain.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 상속 관계 전략 지정 → 부모 엔티티에 설정
@DiscriminatorColumn(name = "dtype")
public abstract class Item {

    @Id
    @Getter
    @Column(name = "item_id")
    private Long id;

    private String name;

    private int price;

    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();
}
