package himedia.testexam.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import himedia.testexam.domain.Item;
import lombok.RequiredArgsConstructor;

@Repository
@Transactional
@RequiredArgsConstructor
public class ItemJpaRepository implements ItemRepository {

	private final EntityManager em;

	@Override
	public Item save(Item item) {
		em.persist(item);
		return item;
	}

	@Override
	public Optional<Item> findById(Long itemId) {
		Item item = em.find(Item.class, itemId);
		return Optional.ofNullable(item);
	}

	@Override
	public Optional<Item> findByName(String itemName) {
		List<Item> result = em.createQuery("select m from Item m where m.itemName = :itemName", Item.class)
				  .setParameter("itemName", itemName).getResultList();
		return result.stream().findAny();
	}
	
	@Override
	public List<Item> findAll() {
		return em.createQuery("select m from Item m", Item.class).getResultList();
	}

	@Override
	public void update(Long itemId, Item updateItem) {
		Item item = em.find(Item.class, itemId);
		item.setItemName(updateItem.getItemName());
		item.setPrice(updateItem.getPrice());
		item.setQuantity(updateItem.getQuantity());
	}
}