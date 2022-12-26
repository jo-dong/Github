package himedia.eighthspring.repository;

import java.util.List;
import java.util.Optional;

import himedia.eighthspring.domain.Item;

public interface ItemInterfaceRepository {
	Item save(Item item);
	Optional<Item> findById(Long id);
	Optional<Item> findByName(String name);
	List<Item> findAll();
	void update(Long itemId, Item updateItem);
	//void clearStore();
}
