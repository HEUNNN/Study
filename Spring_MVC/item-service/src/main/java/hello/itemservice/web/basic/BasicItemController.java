package hello.itemservice.web.basic;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    // 상품 목록 Controller
    @GetMapping // GET /basic/items url이 들어오면 호출되는 메서드이다.
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items); // model에 items라는 이름으로 List<Item> items를 저장한다. view에서는 items 이름으로 데이터를 꺼내서 사용한다.
        return "basic/items"; // basic/items에 해당하는 뷰를 반환한다는 의미이다.
    }

    // 상품 상세 Controller
    @GetMapping("/{itemId}") // GET /basic/items/{itemId}
    public String item(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/item";
    }

    // 상품 등록 폼 Controller -> 등록 폼을 보여주기만 한다.
    // 같은 URL이지만 method 방식으로 구분
    @GetMapping("/add")
    public String addForm() {
        return "basic/addForm";
    }

    // 상품 등록 처리 V1 Controller
    /*@PostMapping("/add")
    public String addItemV1(@RequestParam("itemName") String itemName, // 이름이 같으면 생략 가능
                       @RequestParam Integer price,
                       @RequestParam Integer quantity,
                       Model model) {
        Item item = new Item();
        item.setItemName(itemName);
        item.setPrice(price);
        item.setQuantity(quantity);
        Item savedItem = itemRepository.save(item);
        model.addAttribute("item", savedItem);
        return "basic/item";
    }*/

    // 상품 등록 처리 V2 Controller
    /*@PostMapping("/add")
    public String addItemV2(@ModelAttribute("item") Item item, Model model) {
        itemRepository.save(item);
        // mode.addAttribute("item", item); // @ModelAttribute 사용시 자동으로 추가되기 때문에 생략 가능하다.
        return "basic/item";
    }*/

    // 상품 등록 처리 V3 Controller -> @ModelAttribute의 이름 생략
    public String addItemV3(@ModelAttribute Item item) { // @ModelAttribute의 이름을 생략하면 모델에 저장될 때 클래스 명(앞글자를 소문자로 바꾼)을 사용한다.
        itemRepository.save(item);
//        return "basic/item";
         return "redirect:/basic/items/" + item.getId();
    }

    // 상품 등록 처리 V4 Controller -> 리다이렉트를 보낼때 tag를 붙여서 보낸다. 저장되었습니다와 같은 메시지를보여주기 위해서
    @PostMapping("/add")
    public String addItemV4(@ModelAttribute Item item, RedirectAttributes redirectAttributes) { // @ModelAttribute의 이름을 생략하면 모델에 저장될 때 클래스 명(앞글자를 소문자로 바꾼)을 사용한다.
        Item savedItem = itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true); // "저장되었습니다." 메시지를 위한 flag
        return "redirect:/basic/items/{itemId}";
    }

    // 상품 수정 폼 Controller
    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/editForm";
    }

    // 상품 수정 처리 Controller
    @PostMapping("/{itemId}/edit") // POST /{itemId}/edit URL이 들어오면 해당 method가 실행된다.
    public String edit(@PathVariable Long itemId, @ModelAttribute Item item) { // 수정된 내용이 적용된 item이다.
        itemRepository.update(itemId, item);
        return "redirect:/basic/items/{itemId}"; // Controller mapping을 위한 url이다.
        // return "basic/item"; 으로 하면 수정하고 나서도 url이 ~/~~/edit 이런식으로 되어 있다. -> 이건 그냥 View 이름을 반환
    }

    // 테스트용 데이터 추가
    @PostConstruct
    public void init() {
        itemRepository.save(new Item("testA", 10000, 10));
        itemRepository.save(new Item("testB", 30000, 30));
    }
}
