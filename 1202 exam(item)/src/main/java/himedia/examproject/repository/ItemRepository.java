package himedia.examproject.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import himedia.examproject.domain.Item;

@Repository
public class ItemRepository {
	private static final Map<Long, Item> STORE = new HashMap<>();
	private static long sequence = 0L;
	
	public Item save(Item item) {
		item.setItemId(++sequence);
		STORE.put(item.getItemId(), item);
		return item;
	}

	public Item findById(Long id) {
		return STORE.get(id);
	}

	public List<Item> findAll() {
		List<Item> storeList = new ArrayList<>(STORE.values());
		return storeList;
	}
	
	public void update(Long itemId, Item updateItem) {
		Item findItem = findById(itemId);
		findItem.setItemName(updateItem.getItemName());
		findItem.setPrice(updateItem.getPrice());
		findItem.setQuantity(updateItem.getQuantity());
	}
}
