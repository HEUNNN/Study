package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository // Component scan의 대상이 된다.
public class ItemRepository { // repository를 다루는 기능 제공인 저장, id로 찾기, 모두 찾기 등을 정의한다.  -> 이를 활용하여 도메인을 관리하는 상품 목록/상품 상세/상품 등록/상품 수정 기능 등을 구현한다.

    // @Repository를 붙여서 스프링을 사용하고 있다. 스프링은 싱글톤으로 동작하기 때문에 스프링에서 사용시 static을 붙여주지않아도 된다. 그러나 new ItemRepository를 할 수도 있으니 static을 붙여둔다.
    private static final Map<Long, Item> store = new HashMap<>();
    private static long sequence = 0L;

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        Item item = store.get(id);
        return item;
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values()); //values() -> Returns a Collection view of the values contained in this map.
    }

    public void update(Long itemId, Item updateParam) { // update될 내용이 담겨있는 Item 객체
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() {
        store.clear();
    }
}
