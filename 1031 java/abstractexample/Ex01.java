/*
 * [abstract class]
 * 	1) abstract class 내에 abstract method를 포함할 수 있다는 것 이외엔 
 * 	  다른 class와 차이점이 없다.
 * 	2) abstract class는 객체 생성 불가능
 *  3) polymorphism(다형성) 또는 Inheritance(상속) 사용
 * 
 * [abstract method] : 미완성 method
 * 	1) body를 명시하지 않음
 *  2) child method에 반드시 Overriding 시키고자 할 때 사용 => 강제성!
 * 
 */

package abstractexample;

	// Parent
	// abstract class 
abstract class Parent {
	// member field : instance field
	int num;
	// member field : static field
	static int numTwo;
	
	// abstract method
	public abstract void methodOne();
	
	// instance method(member method)
	public void methodTwo() {
		System.out.println("instance method : methodTwo()");
	}
	
	// static method
	public static void methodThree() {
		System.out.println("static method : methodThree()");
	}
	
	// abstract 와 static은 공존할 수 없음. abstract method는 미완성이기 때문.
//	public static abstract void methodFour();
	
}
	// Child
	// Parent class에 abstract method가 있으면
	// child class는 반드시 그 abstract method를 Overriding 해야한다.
class Child extends Parent {
	
	@Override
	public void methodOne() {
		System.out.println("Overriding Method : methodOne()");
	}
}

public class Ex01 {

	public static void main(String[] args) {

		// 1. child class - create object
		Child c = new Child();
		c.methodOne();
		
		// 2. parent class(abstract) - create object
//		Parent p = new Parent();	: Error => 미완성
		
		// 3. polymorphism
		Parent p = new Child();
		p.methodOne();			// abstract method(Overriding Method) - child class의 overriding 된 method 사용
		p.methodTwo();
		p.methodThree();		// warning : static method이기 때문에 클래스명으로 접근하라는 경고
		Parent.methodThree();
		
	}

}
