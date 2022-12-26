package himedia.eighthspring.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import himedia.eighthspring.domain.Item;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@RequiredArgsConstructor
@Transactional
@Slf4j
public class JPAItemRepository implements ItemInterfaceRepository {
	
	private final EntityManager em;

	@Override
	public Item save(Item item) {
		em.persist(item);
		return item;
	}

	@Override
	public Optional<Item> findById(Long id) {
		Item item = em.find(Item.class, id);
		return Optional.ofNullable(item);
	}

	@Override
	public Optional<Item> findByName(String name) {
		List<Item> result =  em.createQuery("select i from Item i where i.itemName = :name", Item.class)
								.setParameter("name", name)
								.getResultList();
		return result.stream().findAny();
	}

	@Override
	public List<Item> findAll() {
		return em.createQuery("select i from Item i", Item.class)
				.getResultList();
	}

	@Override
	public void update(Long itemId, Item updateItem) {
		log.info("[JPAItemRepository] update method : START");
		log.info("[JPAItemRepository] 상품 종류 ==> {}", updateItem.getItemType());
		log.info("[JPAItemRepository] 상품 종류 : 길이 ==> {}", updateItem.getItemType().toString().length());
		String sql = "update Item i "
				+ "set itemname=:itemname, price=:price, quantity=:quantity"
				+ ", open=:open "
				/* + ", regions=:regions " */
				+ ", itemtype=:itemtype "
				+ ", deliverycode=:deliverycode "
				+ "where id=:id";
		
		int result = em.createQuery(sql)
						.setParameter("itemname", updateItem.getItemName())
						.setParameter("price", updateItem.getPrice())
						.setParameter("quantity", updateItem.getQuantity())
						.setParameter("open", updateItem.getOpen())
				/* .setParameter("regions", updateItem.getRegions()) */
						.setParameter("itemtype", updateItem.getItemType().toString())
						.setParameter("deliverycode", updateItem.getDeliveryCode())
						.setParameter("id", itemId)
						.executeUpdate();	
		
		log.info("[JPAItemRepository] update method : END - result >> {}", result);
		em.clear();
	}

//	@Override
//	public void clearStore() {
//		//		
//	}
}
