package himedia.secondspring.domain;

public class MemberForm {
	// 실제 Web에서 입력받는 이름이 userName에 저장된다. 
	// (HTML input tag의 name도 userName으로 변경해주어야한다.)

	private String userName;
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
