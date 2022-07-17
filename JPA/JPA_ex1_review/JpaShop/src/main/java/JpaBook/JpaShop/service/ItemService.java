package JpaBook.JpaShop.service;

import JpaBook.JpaShop.domain.item.Book;
import JpaBook.JpaShop.domain.item.Item;
import JpaBook.JpaShop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    // 변경 감지 기능 사용 - update
    @Transactional
    public Item updateItem(Long itemId, String name, int price, int stockQuantity) { // 특정 필드만 수정되도록 한다.

        Item findItem = itemRepository.findOne(itemId); // itemId로 실제 DB에 있는 영속 상태의 item을 갖고온다.
        findItem.setName(name);
        findItem.setPrice(price);
        findItem.setStockQuantity(stockQuantity);

        // itemRepository에서 save하여 persist나 merge를 할 필요가 없다. 영속 상태이기 때문이다. DirtyChecking
        return findItem;
    }

    public List<Item> findItems() {
        List<Item> items = itemRepository.findAll();
        return items;
    }

    public Item findOne(Long id) {
        Item findItem = itemRepository.findOne(id);
        return findItem;
    }
}
