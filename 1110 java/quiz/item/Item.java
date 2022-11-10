package item;

public class Item {

	private Long id;
	private String itemName;
	private Integer price;
	private int quantity;
	
	public void setId(Long sequence) {
		this.id = sequence;
	}
	
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Item(String itemName, Integer price, int quantity) {
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
	}
	
	public void showInfo() {
		System.out.println(id + "\t" 
						  + itemName + "\t"
						  + price + "\t"
						  + quantity);
	}
	
	
}
