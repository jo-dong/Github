
/*
 * [polymorphism] 
 * 	: 상속 관계에서만 사용 가능
 * 	: 부모 type의 참조 변수로 자식 type의 객체를 가리킴(접근)
 * 	: 부모의 멤버만 접근 가능 -> 자식의 멤버는 접근 불가
 * 	: 단, Overriding 된 자식의 Member Method는 접근 가능
 * 
 * [Syntax]
 * 		1. 부모_자료형 참조변수 = new = 자식_자료형(); 
 * 		2. 부모_자료형 참조변수 = 자식_참조변수;
 */

package polymorphism;

class Parent {
	private int money = 1_000_000;
	
	public void spend(int money) {
		this.money -= money;
		System.out.println("잔고 >> " + this.money);
	}
	
	void working() {
		System.out.println("Parents : working...");
	}
	
}

class Son extends Parent {
	
	public void study() {
//		System.out.println(super.money);	// Error : private - 같은 class 내에서만 접근 허용
		System.out.println("Son : Studying...");
	}
	
	@Override
	public void spend(int money) {
		System.out.println("Son : Give me " + money + " Won");
	}
	
}

class Daughter extends Parent {
	
	@Override
	public void spend(int money) {
		System.out.println("Daughter : Give me " + money + " Won");
	}
	
	public void play() {
		System.out.println("Daughter : I'm in HongDae");
	}
	
}

public class Ex01 {

	public static void main(String[] args) {

		Son son = new Son();
		System.out.println("---Son---");
		son.working();
		son.study();
		son.spend(200_000);
		
		Daughter daughter = new Daughter();
		System.out.println("---Daughter---");
		daughter.working();
		daughter.spend(500_000);
		
		// polymorphism	========================================================
		// 부모 타입(참조변수의 타입) : Parent != 자식 타입(객체의 타입) : Son	
//		Parent parent = new Son();
		Parent parent = son;	// == Parent parent = (Parent)son : Parent type으로 형 변환 한 것과 같다. 
								// UpCasting(자동 형 변환) : 자식이 부모의 타입으로 형 변환
//		Son son2 = parent;		// Error; DownCasting(강제 형 변환) 필요 : 부모가 자식의 타입으로 형 변환
//		Son son2 = (Son)parent;	// 참조 변수 parent를 자식의 타입(Son)으로 강제 형 변환 해줘야 함.(DownCasting)
		System.out.println("---Parent_Son---");
		parent.working();
//		parent.studying();		// Error : 부모는 자식의 정보를 사용할 수 없음(접근 불가)
		parent.spend(300_000);	// 유일하게 자식의 정보를 볼 수 있는 이유 : Overriding 된 Method
								// Son의 spend() 메소드 실행
		
		Parent parent2 = daughter;
		System.out.println("---Parent_Daughter---");
		parent2.working();
		parent2.spend(2_000);
		
//		Parent parent3 = new Cat();		(X)		// Not a polymorphism!
//		Son s = new Parent();			(X)		// Not a polymorphism!
		
		// 객체 배열	: 하나의 이름으로 여러 개의 객체를 관리	========================
		// Way 1.
		Parent[] pArray = new Parent[] {son, daughter};
		
		// Way 2.
//		Parent[] pArray = new Parent[];
//		pArray[0] = new Son();
//		pArray[1] = new Daughter();
		
		// Son, Daughter 객체 주소
		System.out.println("---Son, Daughter 객체 주소---");
		for(int i=0; i<pArray.length; i++)
			System.out.println(pArray[i]);
		
		// Son, Daughter의 Overriding 된 Method 반복문으로 한 번에 실행
		System.out.println("---(Son, Daughter).spend(100)---");
		for(int i=0; i<pArray.length; i++)
			pArray[i].spend(100);
		
	}

}
