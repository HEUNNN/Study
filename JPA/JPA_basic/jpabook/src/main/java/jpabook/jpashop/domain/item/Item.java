package jpabook.jpashop.domain.item;

import jpabook.jpashop.domain.BaseEntity;
import jpabook.jpashop.domain.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE") // DTYPE은 default
public abstract class Item extends BaseEntity { // Item만 따로 저장할 Table이 필요없다는 가정하에 abstract로 하였다.

    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();
}
