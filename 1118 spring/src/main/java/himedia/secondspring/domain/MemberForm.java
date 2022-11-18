package himedia.secondspring.domain;

public class MemberForm {
	// 실제 Web에서 입력받는 이름이 userName에 저장된다. 
	// (HTML input tag의 name도 userName으로 변경해주어야한다.)

	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
//	private String name;
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}

}
