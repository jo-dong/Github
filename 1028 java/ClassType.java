
/*
 * 클래스는 자료형이다.
 */

public class ClassType {
	
	// 멤버 변수
	int num;
	
	// 생성자
	public ClassType(int num) {
		this.num = num;
	}

	// 멤버 메소드
	public void showNum() {
		System.out.println("멤버 변수 num >> " + this.num);
	}
	
	public static void main(String[] args) {

		ClassType classType = new ClassType(0);
		classType.showNum();
		
	}

}
