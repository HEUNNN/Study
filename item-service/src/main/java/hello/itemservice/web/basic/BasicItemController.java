package hello.itemservice.web.basic;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller // @RestController는 return 하는 string을 view로 찾지않고, string 그 자체를 바디에 담아서 내보낸다.
@RequestMapping("/basic/items")
//@RequiredArgsConstructor // final이 붙은 필드인 ItemRepository itemRepository를 넣은 생성자를 자동으로 만들어준다.
public class BasicItemController {

    private final ItemRepository itemRepository;

    // 아래와 같은 생성자를 @RequiredArgsConstructor가 자동으로 만들어준다.
    @Autowired
    public BasicItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
        // BasicItemController가 스프링 컨테이너에 등록되면서 생성자 주입으로 ItemRepository가 주입된다. (ItemRepository는 @Repository가 있어서, 이미 스프링 빈에 등록되어있다.)
    }

    @GetMapping // /basic/items로 들어오는 GET request -> item 목록을 출력
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "basic/items"; // basic/items에 해당하는 뷰를 반환한다는 의미이다.
    }

    // 테스트용 데이터 추가
    @PostConstruct
    public void init() {
        itemRepository.save(new Item("testA", 10000, 10));
        itemRepository.save(new Item("testB", 30000, 30));
    }
}
