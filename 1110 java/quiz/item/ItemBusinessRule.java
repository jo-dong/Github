package item;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ItemBusinessRule {

	private final static Map<Long, Item> store = new HashMap<>();
	private static Long sequence=(long) 1;

	// findById ==================================================
	private Item findById(Long itemId) {
		Iterator<Entry<Long, Item>> iter = store.entrySet().iterator();
		while(iter.hasNext()) {
			Entry<Long, Item> id = iter.next();
			if(itemId == id.getKey()) 
				return id.getValue();
		}
		return null;
	}
	// ===========================================================
	
	// 1. save
	public void save() {
		System.out.print("상품명, 가격, 수량을 순서대로 입력하세요 ... ");
		String itemName = ItemView.INPUT.next();
		Integer price = ItemView.INPUT.nextInt();
		int quantity = ItemView.INPUT.nextInt();
		
		Item newInfo = new Item(itemName, price, quantity);
		newInfo.setId(sequence);
		
		store.put(sequence++, newInfo);
		System.out.println("상품 정보가 저장되었습니다.\n");
		
	}
	
	// 2. find
	public void find() {
		System.out.print("조회를 원하는 아이디를 입력하세요 ... ");
		Long itemId = ItemView.INPUT.nextLong();
		
		Item findId = findById(itemId);
		
		if(findId == null)
			System.out.println("아이디가 " + itemId + "인 상품이 없습니다.\n");
		else {
			findId.showInfo();
			System.out.println("상품 조회가 완료되었습니다.\n");
		}
	}
	
	// 3. update
	public void update() {
		System.out.print("수정을 원하는 아이디를 입력하세요 ... ");
		Long itemId = ItemView.INPUT.nextLong();
		
		Item findId = findById(itemId);
		
		if(findId == null)
			System.out.println("아이디가 " + itemId + "인 상품이 없습니다.\n");
		else {
			System.out.print("가격, 수량을 입력하세요 ... ");
			Integer price = ItemView.INPUT.nextInt();
			int quantity = ItemView.INPUT.nextInt();
			
			findId.setPrice(price);
			findId.setQuantity(quantity);
						
			System.out.println("상품 수정이 완료되었습니다.\n");
		}
	}
	
	// 4. delete
	public void delete() {
		System.out.print("삭제를 원하는 아이디를 입력하세요 ... ");
		Long itemId = ItemView.INPUT.nextLong();
		
		Item findId = findById(itemId);
		
		if(findId == null)
			System.out.println("해당 상품이 없어서 삭제는 진행하지 않습니다.\n");
		else {
			store.remove(itemId);
			System.out.println(itemId + "번 상품이 삭제되었습니다.");
			System.out.println("상품 삭제가 완료되었습니다.\n");
		}
	}
	
	// 5. findAll
	public void findAll() {
		Iterator<Entry<Long, Item>> iter = store.entrySet().iterator();
		if(store.isEmpty()) {
			System.out.println("저장된 상품 정보가 없습니다.\n");
		}
		else {
			while(iter.hasNext()) {
				iter.next().getValue().showInfo();
			}
			System.out.println();
		}
	}
	
	// 6. clearStore
	public void clearStore() {
		store.clear();
		System.out.println("상품의 모든 정보가 삭제되었습니다.\n");
	}
	
	
	
}
