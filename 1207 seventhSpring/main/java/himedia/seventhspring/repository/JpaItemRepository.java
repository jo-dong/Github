package himedia.seventhspring.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import himedia.seventhspring.domain.Item;

//@Repository
@Transactional
public class JpaItemRepository {

	private final EntityManager em;
	
	@Autowired
	public JpaItemRepository(EntityManager em) {
		this.em = em;
	}

	public Item save(Item item) {
		em.persist(item);
		return item;
	}

	public Optional<Item> findById(Long itemId) {
		Item item = em.find(Item.class, itemId);
		return Optional.ofNullable(item);
	}

	public Optional<Item> findByName(String itemName) {
		List<Item> result = em.createQuery("select m from Item m where m.itemName = :itemName", Item.class)
				  .setParameter("itemName", itemName).getResultList();
		return result.stream().findAny();
	}

	public List<Item> findAll() {
		return em.createQuery("select m from Item m", Item.class).getResultList();
	}

	public void update(Long itemId, Item updateItem) {
		Item item = em.find(Item.class, itemId);
		item.setItemName(updateItem.getItemName());
		item.setPrice(updateItem.getPrice());
		item.setQuantity(updateItem.getQuantity());
	}
}