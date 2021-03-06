package jpabook.jpashop.controller;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/items/new")
    public String createForm(Model model) {

        model.addAttribute("form", new BookForm());
        return "/items/createItemForm";
    }

    @PostMapping("/items/new")
    public String create(BookForm bookForm) { // validation은 이번 강의에서 핵심이 아니기 때문에 생략한다.

        Book book = new Book();
        book.setName(bookForm.getName());
        book.setPrice(bookForm.getPrice());
        book.setStockQuantity(bookForm.getStockQuantity());
        book.setAuthor(bookForm.getAuthor());
        book.setIsbn(book.getIsbn());

        itemService.saveItem(book);
        return "redirect:/items";
    }

    @GetMapping("/items")
    public String list(Model model) {
        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        return "items/itemList";
    }

    @GetMapping("/items/{itemId}/edit")
    public String updateItemForm(@PathVariable("itemId") Long itemId, Model model) {

        Book item = (Book) itemService.findOne(itemId);

        /**
         * book item을 입력 받을 때는 BookForm으로 받고, PostMapping에서 Book 엔티티에 매핑하여 itemService.save 했다.
         * 수정작업을 위해 수정 페이지를 부를 때는 해당 itemId에 맞는 itemService에 저장되어 있는 Book 객체를 꺼내어 BookForm 객체에 매핑하고, model에 넘겨주어 화면으로 출력했다.
         */
        BookForm form = new BookForm();
        form.setId(item.getId());
        form.setName(item.getName());
        form.setPrice(item.getPrice());
        form.setStockQuantity(item.getStockQuantity());
        form.setAuthor(item.getAuthor());
        form.setIsbn(item.getIsbn());

        model.addAttribute("form", form);

        return "items/updateItemForm";

    }

    @PostMapping("items/{itemId}/edit")
    public String update(@PathVariable Long itemId, @ModelAttribute("form") BookForm form) { // @ModelAttribute 생략 가능

        // @ModelAttribute(): 파라미터 값을 특정 자바 객체에 매핑

/*        Book book = new Book();

        book.setId(form.getId());
        book.setName(form.getName());
        book.setPrice(form.getPrice());
        book.setStockQuantity(form.getStockQuantity());
        book.setAuthor(form.getAuthor());
        book.setIsbn(form.getIsbn());

        itemService.saveItem(book);*/

        itemService.update(itemId, form.getName(), form.getPrice(), form.getStockQuantity()); // 변경 감지 사용
        return "redirect:/items";
    }


}
