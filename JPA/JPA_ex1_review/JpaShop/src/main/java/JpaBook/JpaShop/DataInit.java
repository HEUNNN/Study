package JpaBook.JpaShop;

import JpaBook.JpaShop.domain.Address;
import JpaBook.JpaShop.domain.Member;
import JpaBook.JpaShop.domain.item.Book;
import JpaBook.JpaShop.service.ItemService;
import JpaBook.JpaShop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class DataInit {

    private final MemberService memberService;
    private final ItemService itemService;

    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        Book book1 = new Book();
        book1.setName("JPA");
        book1.setPrice(2300);
        book1.setAuthor("kim");
        book1.setStockQuantity(20);
        book1.setIsbn("15467");
        itemService.saveItem(book1);

        Book book2 = new Book();
        book2.setName("MVC");
        book2.setPrice(1500);
        book2.setAuthor("lee");
        book2.setStockQuantity(100);
        book2.setIsbn("15683");
        itemService.saveItem(book2);

        Member member1 = new Member();
        member1.setName("A");
        member1.setAddress(new Address("서울", "강남", "14234"));
        memberService.join(member1);

        Member member2 = new Member();
        member2.setName("B");
        member2.setAddress(new Address("부산", "진구", "19887"));
        memberService.join(member2);
    }
}
