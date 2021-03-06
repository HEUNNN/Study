package hello.itemservice.web.form;

import hello.itemservice.domain.item.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@Controller
@RequestMapping("/form/items")
@RequiredArgsConstructor // final 혹은 @NotNull 애노테이션이 붙은 필드의 생성자를 자동으로 생성해준다.
@Slf4j
public class FormItemController {

    private final ItemRepository itemRepository;

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "form/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "form/item";
    }

    // @ModelAttribute로 등록지역 체크박스를 위한 지역 데이터 넘겨주기, 이전에 사용하던 ModelAttribute와 기능이 다르다.
    @ModelAttribute("regions")
    public Map<String, String> regions() {
        Map<String, String> regions = new LinkedHashMap<>(); // 순서 보장을 위해 LinkedHashMap 사용
        regions.put("SEOUL", "서울");
        regions.put("BUSAN", "부산");
        regions.put("JEJU", "제주");
        return regions;
    }

    // @ModelAttribute로 item type 라디오 버튼 만들기
    @ModelAttribute("itemTypes")
    public ItemType[] itemTypes() {
        return ItemType.values(); // ENUM 의 모든 정보를 배열로 반환한다.
    }

    // @ModelAttribute로 deliberyCodes 셀렉트 박스 만들기

/*    @ModelAttribute("deliveryCodes")
    public List<DeliveryCode> deliveryCodes() {
        List<DeliveryCode> deliveryCodes = new ArrayList<>();
        deliveryCodes.add(new DeliveryCode("FAST", "빠른 배송"));
        deliveryCodes.add(new DeliveryCode("NORMAL", "일반 배송"));
        deliveryCodes.add(new DeliveryCode("SLOW", "느린 배송"));

        return deliveryCodes;
    }*/

    // @ModelAttribute를 사용하면 deliveryCodes() 메서든느 컨트롤러가 호출 될 때마다 사용되므로 deliverCodes 객체도 매번 생성되기 때문에,
    // 미리 생성해두고 재사용하도록 변경하였다.
/*    List<DeliveryCode> deliveryCodes = DeliveryCode.add();

    @ModelAttribute("deliveryCodes")
    public List<DeliveryCode> deliveryCodes() {
        return deliveryCodes;
    }*/

    // deliveryCodes 셀렉트 박스 ENUM으로 만들기
    @ModelAttribute("deliveryCodes")
    public DeliveryCodeEnum[] deliveryCodeEnums() {
        return DeliveryCodeEnum.values();
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        // 입력 폼 처리를 위해 빈 객체 넘겨준다.
        model.addAttribute("item", new Item());

        // 등록지역 체크 박스를 위해 Map data를 넘겨준다.
/*        Map<String, String> regions = new LinkedHashMap<>();
        regions.put("SEOUL", "서울");
        regions.put("BUSAN", "부산");
        regions.put("JEJU", "제주");
        model.addAttribute("regions", regions);
*/
        return "form/addForm";
    }

    @PostMapping("/add")
    public String addItem(@ModelAttribute Item item, RedirectAttributes redirectAttributes) {

        // @ModelAttribute: POST 요청에 담겨온 파라미터 값을 특정 자바 객체에 매핑한다. 또 model 객체에 자동으로 addAttribute(item) 해준다.
        // HTML Form에서 POST 방식의 파라미터 형식 데이터를 넘겨준다.
        log.info("item.getOpen={}", item.getOpen());
        log.info("item.getRegions={}", item.getRegions());
        log.info("item.getItemType={}", item.getItemType());
        Item savedItem = itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", savedItem.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/form/items/{itemId}";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "form/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @ModelAttribute Item item) {
        itemRepository.update(itemId, item);
        return "redirect:/form/items/{itemId}";
    }

}

