package himedia.seventhspring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import himedia.seventhspring.domain.Item;

public interface SpringDataJpaItemRepository extends JpaRepository<Item, Long> {
	public Optional<Item> findByItemName(String itemName);
	
	default void update(Long itemId, Item updateItem) {
		Item item = findById(itemId).get();
		item.setItemName(updateItem.getItemName());
		item.setPrice(updateItem.getPrice());
		item.setQuantity(updateItem.getQuantity());
		save(item);
	}
}
