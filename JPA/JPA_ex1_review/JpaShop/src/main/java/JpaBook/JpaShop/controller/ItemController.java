package JpaBook.JpaShop.controller;

import JpaBook.JpaShop.domain.item.Book;
import JpaBook.JpaShop.domain.item.Item;
import JpaBook.JpaShop.service.ItemService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Slf4j
@Controller
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/items/new")
    public String createForm(Model model) {
        model.addAttribute("form", new BookForm());

        return "items/createItemForm";
    }

    @PostMapping("/items/new")
    public String create(BookForm form) {
        Book book = new Book();
        book.setName(form.getName());
        book.setPrice(form.getPrice());
        book.setStockQuantity(form.getStockQuantity());
        book.setAuthor(form.getAuthor());
        book.setIsbn(form.getIsbn());

        itemService.saveItem(book); // 이 과정에서 id가 정해진다.

        return "redirect:/items";
    }

    // 상품 목록
    @GetMapping("/items")
    public String list(Model model) {
        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        return "items/itemList";
    }

    // 상품 수정
    @GetMapping("/items/{itemId}/edit")
    public String updateItemForm(@PathVariable("itemId") Long itemId, Model model) {
        Book findBook = (Book) itemService.findOne(itemId);
        BookForm form = new BookForm();
        form.setId(findBook.getId()); // ItemRepository에서 id가 있으면 em.merge(item)을 하여 업데이트를 하고, id가 없으면 em.persist(item)으로 영속성 컨텍스트에 (최초로)영속 시킨다.
        form.setName(findBook.getName());
        form.setPrice(findBook.getPrice());
        form.setStockQuantity(findBook.getStockQuantity());
        form.setAuthor(findBook.getAuthor());
        form.setIsbn(findBook.getIsbn());

        model.addAttribute("form", form);

        return "items/updateItemForm";
    }

    @PostMapping("/items/{itemId}/edit")
    public String updateItem(@ModelAttribute("form") BookForm form) {

        Book book = new Book();
        book.setId(form.getId());
        book.setName(form.getName());
        book.setPrice(form.getPrice());
        book.setStockQuantity(form.getStockQuantity());
        book.setAuthor(form.getAuthor());
        book.setIsbn(form.getIsbn());

        itemService.saveItem(book); // itemRepository에서 id의 유무에 따라 persist or merge
        return "redirect:/items";

    }
}
