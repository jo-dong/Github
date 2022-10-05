/*
 * Class ?
 *  Class = 사용자 정의 자료형 !
 * 	cf) 기본 자료형(primitive(원시) : int, float, double, ...)
 * 		참조형	   (reference type)	 
 * 
 *   - Class명은 대문자로 시작
 *   - Class 내 멤버 : 변수(멤버 변수), Method(Member Method)
 *   
 *   - 객체(object), 인스턴스(Instance) : 클래스로 생성된 구체화(실체화) 된 대상
 *   - 자바는 모든 객체를 Heap 영역에 생성 -> 멤버도 Heap 영역에 할당
 *   - 객체는 Heap 영역에 생성되면, 할당된 메모리 주소를 리턴(반환)
 *   - 생성된 객체는 반드시 주소(이름 X)를 통해 접근
 *   
 *   - 객체 생성 문법
 *    : new + 클래스명();
 *    
 *   - 참조(reference) 변수
 *    : 클래스명 + 변수명;
 *   
 *   				선언되는 위치			메모리 할당 시기		메모리 해제 시기	메모리 영역		초기값(default)
 *   지역 변수 : {} 영역 내에서 선언	해당 영역이 실행될 때	해당 영역이 종료될 때		Stack			쓰레기값
 *   멤버 변수 : 클래스 내에서 선언		객체가 생성이 될 때		객체가 소멸이 될 때			Heap		  	0, null
 *   
 */


// Class 정의
class Student {
	// 멤버 변수
	int age;
	String name;	// name : 참조 변수
	
	// 멤버 Method
	void study() {
		System.out.println("Study Hard!");
	}
}

public class InstanceEx01 {		// 객체(인스턴스) -> Heap 영역에만 만들어짐

	public static void main(String[] args) {
		// 변수 선언
		// 자료형 + 변수명;
		int num;
		num = 1;						// initialize
		
		// 클래스 + 변수명;				// className 뒤에 오는 변수 : 무조건 참조 변수
		// 참조 변수 선언
		Student hong;					// hong : 지역 변수(참조 변수), Student의 주소가 저장됨. -> 주소는 정수(int, 4바이트)
		// 객체 생성 : new className();
		hong = new Student();			// new : 연산자(RAM 안의 Heap 영역에 할당하라는 의미). Heap 영역은 이름을 정할 수 없음.
										// Student라는 클래스를 Heap 영역에 할당하여라.
		
		// Student hong = new Student();	한 줄로 합치기 (hong은 stack, Student는 Heap 영역에 할당)
		
		System.out.println("멤버 변수 age의 초기값 >> " + hong.age);
		// output : 0					 					 . : 접근 연산자
		
		hong.age = 25;
		System.out.println("멤버 변수 age의 값 >> " + hong.age);	// age, name와 같은 멤버 변수들은 바로 사용 불가
																	// (hong을 통해 주소를 찾아서 사용 가능)
		// 초기화를 따로 하지 않아도 JVM이 알아서 0으로 초기화 시킴
				
		// 참조 변수의 초기화(initialize)
		int var = 0;
		String str = null;		// str -> 찾아갈(참조할) 메모리 없음
		
		System.out.println("멤버 변수 name의 초기값 >> " + hong.name);
		// output : null(String이기 때문에 null 출력)
		
		// Member Method study() 호출
		hong.study();
	}

}
