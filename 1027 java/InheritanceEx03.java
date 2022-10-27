
class ParentThree {
	String name;
	
	public ParentThree() {

	}
	
	// 기본 생성자 이외에 다른 생성자가 있으면
	// 기본 생성자는 자동 실행이 안 되기 때문에
	// 자식 생성자가 호출을 한다면 기본 생성자를 만들어 주어야 한다.
	public ParentThree(String name) {
		this.name = name;
	}
}

class ChildThree extends ParentThree {
	
	// default constructor
	public ChildThree() {	// super(); 생략
		
	}
}

public class InheritanceEx03 {

	public static void main(String[] args) {

		
		
	}

}
