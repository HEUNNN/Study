package JpaBook.JpaShop.service;

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

    public List<Item> findItems() {
        List<Item> items = itemRepository.findAll();
        return items;
    }

    public Item findOne(Long id) {
        Item findItem = itemRepository.findOne(id);
        return findItem;
    }
}
