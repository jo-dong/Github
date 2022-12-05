package himedia.seventhspring.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import himedia.seventhspring.domain.Item;

@SpringBootTest
class ExamProjectApplicationTests {

	ItemRepository repo = new ItemRepository();
	
	@AfterEach
	void clearStore() {
		repo.clearStore();
	}
	
	@Test
	void save() {
		Item item = new Item("초코파이", 1000, 3);
		
		Item savedItem = repo.save(item);
		
		assertThat(item.getItemName()).isEqualTo(savedItem.getItemName());
	}
	
	@Test
	void findById() {
		Item item = new Item("초코파이", 1000, 3);
		
		repo.save(item);
		
		Item savedItem = repo.findById(item.getItemId());
		
		assertThat(item.getItemName()).isEqualTo(savedItem.getItemName());
	}
	
	@Test
	void findByName() {
		Item item = new Item("초코파이", 1000, 3);
		
		repo.save(item);
		
		Optional<Item> savedItem = repo.findByName("초코파이");
		Optional<Item> unsavedItem = repo.findByName("바나나우유");
		
		assertThat(item.getItemName()).isEqualTo(savedItem.get().getItemName());
		assertThat(unsavedItem).isEqualTo(Optional.empty());
	}
	
	@Test
	void findAll() {
		List<Item> before = repo.findAll();
		Item item = new Item("초코파이", 1000, 3);
		Item item2 = new Item("바나나우유", 2000, 5);
		repo.save(item);
		repo.save(item2);
		List<Item> after = repo.findAll(); 
		assertThat(before.size()).isEqualTo(after.size() - 2);
	}
	
	@Test
	void update() {
		Item item = new Item("초코파이", 1000, 3);
		repo.save(item);
		repo.update(item.getItemId(), new Item("바나나우유", 2000, 5));
		
		Item updatedItem = repo.findById(item.getItemId());
		
		assertThat(updatedItem.getItemName()).isEqualTo("바나나우유");
	}

}