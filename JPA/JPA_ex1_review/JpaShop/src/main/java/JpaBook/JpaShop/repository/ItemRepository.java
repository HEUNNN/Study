package JpaBook.JpaShop.repository;

import JpaBook.JpaShop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item) {
        if (item.getId() == null) { // id가 없다는 것은 persist 된 적이 없다는 것을 의미한다.
            em.persist(item);
        } else {
            em.merge(item); // merge는 update와 유사하다.
        }
    }

    public Item findOne(Long id) {
        Item findItem = em.find(Item.class, id);
        return findItem;
    }

    public List<Item> findAll() {
        List<Item> items = em.createQuery("select i from Item i", Item.class).getResultList();
        return items;
    }

    
}
