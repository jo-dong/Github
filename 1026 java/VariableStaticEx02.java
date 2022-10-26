/*
 * 
 * << static(class) 변수 >>
 *  : class가 메모리에 Load될 때, static(class) 영역에 할당
 *  : 객체 생성과 상관 없이 접근(사용) 가능
 *  	-> 객체 생성 없이 멤버 변수를 사용하고자 할 때 사용
 *  [Syntax]
 *  	: 클래스명.변수명
 *  	: 해당 클래스로 생성된 객체들이 공유하는 변수
 *  	
 *  << static(class) Method >>
 *  : class가 메모리에 Load될 때, static 영역에 할당
 *  : 객체 생성과 상관 없이 접근(사용) 가능
 *  : static(class) 메소드 내에서는 static member만 접근(사용) 가능
 *  	-> 객체 생성 없이 메소드를 호출하고자 할 때 사용
 *  
 *  [Syntax]
 *  	: 클래스명.메소드명
 * 	
 * 	<Instance Method>
 * 		: static, instance 변수 모두 접근 가능
 */

class Dog {
	// 멤버 변수
	// : static(class) 변수
	static int count;
	// : instance 변수
	String name;
	
	// 멤버 메소드
	// : static(class) 메소드
	static void increment() {
		Dog.count++;
//		System.out.println(name);	
		// Error : instance member(name)는 static member보다 
		// 		   늦게 만들어지기 때문에 static method(increment())에서 사용 불가
	}
	
	// : instance 메소드
	void showInfo() {
		System.out.println("강아지 이름 >> " + this.name);
	}
}

public class VariableStaticEx02 {

	public static void main(String[] args) {

		System.out.println("현재 강아지 마리수 >> " + Dog.count);
		Dog.increment();
		System.out.println("현재 강아지 마리수 >> " + Dog.count);
		
	}

}
