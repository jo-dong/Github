package himedia.eighthspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import himedia.eighthspring.domain.Item;

public interface SpringDataJpaItemRepository extends JpaRepository<Item, Long> {
	
}
