package himedia.testexam.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="Item")
public class Item {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ITEMID")
	private Long id;
	@Column(name = "ITEMNAME")
	private String itemName;
	@Column(name = "PRICE")
	private Integer price;
	@Column(name = "QUANTITY")
	private Integer quantity;
	
	public Item() {}
	
	public Item(String itemName, Integer price, Integer quantity) {
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}
}
