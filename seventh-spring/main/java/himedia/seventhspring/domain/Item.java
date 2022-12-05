package himedia.seventhspring.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Item {
	private Long itemId;
	private String itemName;
	private int price;
	private int quantity;
	
	// constructor(id 제외) - id는 자동 생성
	public Item(String itemName, int price, int quantity) {
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}
}
