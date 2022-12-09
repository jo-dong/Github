package himedia.testexam.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import himedia.testexam.domain.Item;

@SpringBootTest
@Transactional
class ItemJpaRepositoryTest {
	
	@Autowired ItemJpaRepository repository;
	
	@Test
	void save() {
		// given
		Item item = new Item("chocolate", 3000, 20);

		// when
		Item savedItem = repository.save(item);
		
		// then
		assertThat(savedItem.getItemName()).isEqualTo(item.getItemName());
	}
	
	@Test
	void findById() {
		// given
		Item item = new Item("초코파이", 1000, 3);
		repository.save(item);
		
		// when
		Item savedItem = repository.findById(item.getId()).get();
		
		// then
		assertThat(item.getItemName()).isEqualTo(savedItem.getItemName());
	}
	
	@Test
	void findByName() {
		// given
		Item item = new Item("초코파이", 1000, 3);
		repository.save(item);
		
		// when
		Optional<Item> savedItem = repository.findByName(item.getItemName());
		Optional<Item> unsavedItem = repository.findByName("바나나우유");
		
		// then
		assertThat(item.getItemName()).isEqualTo(savedItem.get().getItemName());
		assertThat(unsavedItem).isEqualTo(Optional.empty());
	}
	
	@Test
	void findAll() {
		// given
		List<Item> before = repository.findAll();
		Item item = new Item("초코파이", 1000, 3);
		Item item2 = new Item("바나나우유", 2000, 5);
		repository.save(item);
		repository.save(item2);
		
		// when
		List<Item> after = repository.findAll(); 
		
		// then
		assertThat(before.size()).isEqualTo(after.size() - 2);
	}
	
	@Test
	void update() {
		// given
		Item item = new Item("초코파이", 1000, 3);
		repository.save(item);
		
		// when
		Item changeItem = new Item("바나나우유", 2000, 5);
		repository.update(item.getId(), changeItem);
		
		Item updatedItem = repository.findByName(changeItem.getItemName()).get();
		
		// then
		assertThat(updatedItem.getItemName()).isEqualTo(changeItem.getItemName());
	}

}
