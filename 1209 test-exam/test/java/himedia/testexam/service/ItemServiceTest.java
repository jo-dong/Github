package himedia.testexam.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import himedia.testexam.domain.Item;

@SpringBootTest
@Transactional
class ItemServiceTest {

	@Autowired ItemService itemService;
	
	@Test
	void saveItem() {
		// given
		Item item = new Item("chocolate", 3000, 20);
		
		// when
		Item savedItem = itemService.saveItem(item);
		
		// then
		assertThat(item.getItemName()).isEqualTo(savedItem.getItemName());
	}
	
	@Test
	void findByIdItem() {
		// given
		Item item = new Item("chocolate", 3000, 20);
		itemService.saveItem(item);
		
		// when
		Item checkId = itemService.findByIdItem(item.getId()).get();
		
		// then
		assertThat(item.getItemName()).isEqualTo(checkId.getItemName());
	}
	
	@Test
	void findByNameItem() {
		// given
		Item item = new Item("chocolate", 3000, 20);
		itemService.saveItem(item);
		
		// when
		Item checkName = itemService.findByNameItem(item.getItemName()).get();
		
		// then
		assertThat(item.getPrice()).isEqualTo(checkName.getPrice());
	}
	
	@Test
	void findAllItems() {
		// given
		List<Item> before = itemService.findAllItems();
		Item item1 = new Item("chocolate", 3000, 20);
		Item item2 = new Item("milk", 1500, 10);
		itemService.saveItem(item1);
		itemService.saveItem(item2);
		
		// when
		List<Item> after = itemService.findAllItems();
		
		// then
		assertThat(before.size()).isEqualTo(after.size() - 2);
	}
	
	@Test
	void updateItem() {
		// given
		Item item = new Item("chocolate", 1000, 3);
		itemService.saveItem(item);
		
		// when
		Item changeItem = new Item("milk", 2000, 5);
		itemService.updateItem(item.getId(), changeItem);
		
		Item updatedItem = itemService.findByNameItem(changeItem.getItemName()).get();
		
		// then
		assertThat(updatedItem.getItemName()).isEqualTo(changeItem.getItemName());
	}

}
