package polymorphism;

public class Ex02 {

	public static void main(String[] args) {

		Parent p = new Parent();
		Son s = new Son();
		Daughter d = new Daughter();
		
		// Polymorphism	
		Parent p2 = new Son();		// UpCasting
		
		// 형 변환 가능 여부	==================================================================
		// {Syntax} : (참조변수 or 객체) instanceof (자료형)
		System.out.println("---Parent Type과 비교---");
		System.out.println(p instanceof Parent);	// true
		System.out.println(p2 instanceof Parent);	// true
		System.out.println(s instanceof Parent);	// true (UpCasting 관계)
		System.out.println(d instanceof Parent);	// true (UpCasting 관계)
		
		System.out.println("---Son Type과 비교---");
		System.out.println(p instanceof Son);		// false (DownCasting 관계) - 강제 형 변환 필요
		System.out.println(p2 instanceof Son);		// true : Polymorphism
		System.out.println(s instanceof Son);		// true
//		System.out.println(d instanceof Son);		// Error : 둘 다 sub class 
		
		// Overriding 되지 않은 Method 사용법	======================================================
		System.out.println("---Overriding 되지 않은 Method 사용법---");
		Parent[] mother = {new Son(), new Daughter()};
		mother[0].working();
//		mother[0].study();				// Error : Overriding 되지 않은 Method
//		mother[1].play();				// Error : Overriding 되지 않은 Method
//		(Son)mother[0].study();			// Error : .(접근 연산자)가 우선 순위가 더 강함
		((Son)mother[0]).study();		// 괄호로 묶어줘야 함
		((Daughter)mother[1]).play();	// 괄호로 묶어줘야 함
		
		System.out.println("---향상된 for문---");
		// 향상된 for 문	==========================================================================
		// for(자료형 변수명 : 참조변수)
		for(Parent parent : mother) {
			if(parent instanceof Son) {
				((Son) parent).study();
			}
			else if (parent instanceof Daughter) {
				((Daughter) parent).play();
			}
		}
		
	}

}
