package JpaBook.JpaShop.domain.item;

import JpaBook.JpaShop.domain.Category;
import JpaBook.JpaShop.exception.NotEnoughStockException;
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

    // === 비즈니스 로직 추가 === //
    // 엔티티 자체가 해결할 수 있는 부분들은 엔티티 내부에 비즈니스 로직을 추가하는 것이 좋다. → 객체 지향적

    public void addStock(int quantity) { // 재고 ++ 비즈니스 로직
        this.stockQuantity += quantity;
    }

    public void removeStock(int quantity) { // 재고 -- 비즈니스 로직
        int restStock = this.stockQuantity - quantity;
        if (restStock < 0) {
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }

}
