package JpaBook.JpaShop.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookForm {

    // Book 도메인 엔티티는 id @GeneratedValue 가 아니다. 부모인 Item은 Id가 @GeneratedValue 이다.
    private Long id;
    private String name;
    private int price;
    private int stockQuantity;
    private String author;
    private String isbn;
}
