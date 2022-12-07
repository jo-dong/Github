package himedia.seventhspring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity @Getter @Setter
public class Item {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ITEMID")
	private Long itemId;
	@Column(name = "ITEMNAME")
	private String itemName;
	@Column(name = "PRICE")
	private int price;
	@Column(name = "QUANTITY")
	private int quantity;
	
	// constructor(id 제외) - id는 자동 생성
	public Item(String itemName, int price, int quantity) {
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}
}
