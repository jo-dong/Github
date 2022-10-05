
// Person class 정의
class Person {		// class는 같은 bin 폴더 내에 동일한 이름으로 만들 수 없다.(다른 폴더는 가능) - 중복을 막기 위해 Package 사용
	
	// 멤버 변수
	int age;
	String name;
	String address;
	
	// 멤버 Method
	// setter, getter ----------------------
	// 멤버 변수 값 설정 : set
	// 멤버 변수 값 리턴 : get
	void setAge(int age) {			// setter
		this.age = age;				// this = 참조 변수
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	String getName() {				// getter
		return name;
	}
	
	void showAge() {
		// int age = 100;		// 출력되는 age 우선순위 : 1. 지역 변수(메소드 안에 설정된 age 값) 2. 멤버 변수
		// int age = 100; : age --> 지역 변수. showAge() 메소드가 실행될 때 생성되었다가 종료될 때 삭제됨. stack에 할당.
		System.out.println("나이 >> " + age);
	}
	
	void showInfo() {
		System.out.println("this >> " + this);
	}
	
}


public class InstanceEx02 {

	public static void main(String[] args) {

		// 1. 참조 변수 선언 -----------------
		// 자료형 + 변수명;
		// 클래스명 + 참조 변수명;
		Person p1;
		
		// 2. 객체 생성 ----------------------
		// new + 클래스명(); --> Heap 영역에 class 멤버 할당
		p1 = new Person();
		
		// 3. 멤버 접근 ----------------------
		// 3-1. 멤버 변수에 값 설정 ==> 객체 지향에서 권장하지 않음.
		
		// p1.age = 25;				// 참조 변수를 통한 멤버 변수 값 설정(외부 접근), 권장 X.
		// p1.name = "홍길동";
		// p1.address = "인천";
		
		p1.setAge(28);				// 다른 Member Method를 만들어서 접근, 권장 O.
		p1.setName("조동현");
		
		// 3-2. 멤버 메소드 호출
		p1.showAge();
		System.out.println("이름 >> " + p1.getName());
		
		// 4. 참조 변수 p1 & this
		p1.showInfo();	// output : Person@2d363fb3		Person : 자료형(ClassName)  2d363fb3 : 16진수로 나타낸 주소
		System.out.println("p1 >> " + p1); 	// output : Person@2d363fb3 
				// this 주소 = p1 주소
		
		
	}

}








