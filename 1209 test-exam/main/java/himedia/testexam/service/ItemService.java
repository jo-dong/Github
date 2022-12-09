package himedia.testexam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import himedia.testexam.domain.Item;
import himedia.testexam.repository.ItemRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {

	private final ItemRepository itemRepository;
	
	public Item saveItem(Item item) {
		itemRepository.save(item);
		return item;
	}

	public Optional<Item> findByIdItem(Long id) {
		return itemRepository.findById(id);
	}

	public Optional<Item> findByNameItem(String itemName) {
		return itemRepository.findByName(itemName);
	}
	
	public List<Item> findAllItems() {
		return itemRepository.findAll();
	}
	
	public void updateItem(Long itemid, Item updateItem) {
		itemRepository.update(itemid, updateItem);
	}
}
