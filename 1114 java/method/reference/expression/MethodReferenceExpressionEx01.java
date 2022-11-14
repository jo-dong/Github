package method.reference.expression;

/*
 * [Method Reference Expression] - 참조 : 주소의 의미
 *  Method 참조 표현식 - 람다식에서만 사용하는 것은 아님
 *  이중 콜론 연산자 (::) 사용
 *  함수형 인터페이스를 람다식이 아닌 일반 메소드를 참조시켜 선언하는 방법
 *  즉, 컴파일러가 람다의 타입을 추론할 수 있도록 정보를 제공하는 역할
 *  
 *   [functional interface]
 *  	- interface는 반드시 abstract method가 1개
 *  	 : (Single Abstract Method : SAM)
 *  	 : @FunctionalInterface Annotation으로 보장
 *  
 *   - 선언부가 완전히 같아야 함
 *   - 매개 변수 정보와 return type은 동일하고 기능만 다르다는 것이 핵심.
 *   
 *   - Return Type과 Parameter Type이 동일한 "기존에 구현된" 메소드를
 *     빈 껍데기에 참조만 하면 더 간편하게 사용 가능
 *     
 *   - 참조만 하기 때문에 method name만 사용하고 ()는 제외
 *   
 *   - 참조 가능한 method
 *     : instance method, static method, constructor
 *     
 *   [Syntax]
 *   1) instance::method_name		// () 괄호 없음 
 *   2) instance::new
 *   3) class_name::method_name		- static method의 경우
 *  
 */

@FunctionalInterface
interface Fruit {
	// abstract method
	String selfIntroduction(String n1, String n2);
}

// 꼭! interface의 abstract method를 class로 구현해야 하는가?
// abstract method -> anonymous class -> Lambda Expression -> Method Reference Expression

// Inheritance
class Banana implements Fruit {
	@Override
	public String selfIntroduction(String n1, String n2) {
		return "[Inheritance]".concat(" ") + n1.concat(" ").concat(n2);
	}
}

// Add class는 Fruit interface와 아무 관련이 없음(상속 X, Overriding X)
// Add class의 staticAdd, instanceAdd method의 선언부 = Fruit interface의 abstract method
class Add {
	// constructor	: interface와 연관 X
	public Add() {
		System.out.println("Add() 생성자 실행됨");
	}
	
	// ========================================================================
	// interface Fruit의 abstract method와 
	// [Return Type, parameter 정보]가 동일한 method 생성 (method name과는 상관 X)
	
	// static method
	static String staticAdd(String n1, String n2) {
		return n1 + "-" + n2;
	}
	
	// instance method
	String instanceAdd(String n1, String n2) {
		return n1.concat(", ").concat(n2);
	}
	// ========================================================================
}

public class MethodReferenceExpressionEx01 {

	public static void main(String[] args) {

		// 1. Create Object ==========================================================
		Banana banana = new Banana();
		System.out.println(banana.selfIntroduction("Hi", "I'm Banana."));
		
		// 2. Anonymous Class ========================================================
		Fruit anonymous = new Fruit() {
			@Override
			public String selfIntroduction(String n1, String n2) {
				return "[Anonymous]".concat(" ") + n1.concat(" ").concat(n2);
			}
		};
		System.out.println(anonymous.selfIntroduction("Nice to", "Meet you."));
		
		// 3. Lambda Expression ======================================================
		Fruit lambda = (n1, n2) -> "[Lambda]".concat(" ") + n1.concat(" ").concat(n2);
		System.out.println(lambda.selfIntroduction("How", "Are You?"));
		
		// ======================= Method Reference Expression =======================
		// 4-1. Instance =============================================================
		// Add class의 instance method를 빌려서(참조해서) 사용
		Add add = new Add();
		Fruit fruit = add::instanceAdd;			// instance::method_name
		System.out.println(fruit.selfIntroduction("[Add] instance", "method"));
		
		// 4-2. Static ===============================================================
		Fruit staticFruit = Add::staticAdd;		// class_name::method_name
		System.out.println(staticFruit.selfIntroduction("[Add] static ", " method"));
		
		// [Quiz] 생성자는 어떻게 참조할까요? --------------------------------------------
		// Add class의 constructor : 매개변수 X, 리턴값 X
		// Runnable : java.lang package - interface
		// 			: run() - 매개변수 X, 리턴값 X
		Runnable constructor = Add::new;
		System.out.print("Runnable을 통해 Add 생성자 실행 >> ");
		constructor.run();
		// ===========================================================================
		
	}

}
