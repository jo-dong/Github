package himedia.fourthspring.domain;

// Search할 때에 post 방식으로 받기 때문에 새로운 Domain 작성
public class SearchForm {
	private Long id;
	private String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
