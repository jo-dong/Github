package himedia.eighthspring.domain;

// enum type
public enum ItemType {
	BEAUTY("뷰티"), BOOK("도서"), FASHION("패션"), FOOD("식품"), ETC("기타");
	//BEAUTY("BEAUTY"), BOOK("BOOK"), FASHION("FASHION"), FOOD("FOOD"), ETC("ETC");
	
	// field
	private final String description;
	
	// constructor
	private ItemType(String description) {
		this.description = description;
	}
	
	// getter
	public String getDescription() {
		return description;
	}
}
