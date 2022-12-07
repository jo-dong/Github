package himedia.seventhspring.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import himedia.seventhspring.domain.Item;

//@Repository
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
	
	// findByName Method 추가 [stream] ==============================================
	public Optional<Item> findByName(String itemName) {
		return STORE.values().stream().filter(item -> item.getItemName().equals(itemName)).findAny();
	}
	// [Enhanced for-loop]
//	public Item findByName(String itemName) {
//		for(Entry<Long, Item> i : STORE.entrySet()) {
//			if(i.getValue().getItemName().equals(itemName))
//				return i.getValue();
//		}
//		return null;

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
	
	public void clearStore() {
		STORE.clear();
	}
}
