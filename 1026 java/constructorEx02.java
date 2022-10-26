/*
 * [객체 생성 시 순서]
 * 	1. 메모리 할당
 * 	2. 생성자 호출
 * 
 * [this 형태]
 * 	1. this.멤버 변수
 * 	2. this.멤버 메소드	: 생성자 내에서 멤버 메소드 호출 시
 *  3. this(매개변수 x, 매개변수 y, ...) : 생성자 내에서 다른 생성자 호출 시
 */

class Student {
	// 멤버 변수 : Instance 변수(객체 변수)
	int age;
	String name;
	
	// 생성자 overloading
	// 매개변수가 없는 생성자(기본 생성자) - 생성자를 통해 멤버 변수를 초기화
	public Student() {
		this(0, "미입력");			// 생성자 내에서 다른 생성자 호출 가능	: 생성자 내에서 가장 윗 줄에 있어야 함 
		// this.age = 0;
		// this.name = "미입력";
//		this.showInfo();			// 생성자 내에서 메소드 호출 가능
	}
	// 매개변수가 1개인 생성자
	public Student(String name) {
		this(20, name);
		// this.age = 0;
		// this.name = name;
		// 생성자 내에서 다른 생성자 호출!
	}
	// 매개변수가 2개인 생성자
	public Student(int age, String name) {
		this.age = age;
		this.name = name;
		this.showInfo();
	}

	// 멤버 메소드
	public void showInfo() {
		System.out.println("이름은 " + this.name + "이고, 나이는 " + this.age + "입니다.");
	}
	
}

public class constructorEx02 {

	public static void main(String[] args) {

		Student noName = new Student();
//		noName.showInfo(); 			// 출력 -> 이름은 미입력이고, 나이는 0입니다.
		
		Student hong = new Student(29, "홍길동");
//		hong.showInfo(); 			// 출력 -> 이름은 홍길동이고, 나이는 29입니다.
		
		Student park = new Student("박보검");
//		park.showInfo(); 			// 출력 -> 이름은 박보검이고, 나이는 0입니다.
	}

}
