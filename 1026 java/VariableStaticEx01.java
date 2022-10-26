
class Baseball {
	// 멤버 변수 : 인스턴스(객체) 변수
//	int count = 10;
	
	// 멤버 변수 : static(class) 변수
	// static 은 class를 통해 바로 접근하는 것이 좋다.
	// ex) Baseball.count
	static int count = 10;
	
	// 멤버 메소드 : 인스턴스(객체) 메소드
	void increment() {
		count++;
	}
	
	void decrement() {
		count--;
	}
	
	void baseballInfo() {
		System.out.println("현재 개수 : " + this.count);
	}
	
}

public class VariableStaticEx01 {

	public static void main(String[] args) {

		System.out.println("static 멤버 변수 >> " + Baseball.count);
		
		Baseball b1 = new Baseball();
		b1.increment();
		b1.baseballInfo();
		
		Baseball b2 = new Baseball();
		b2.increment();
		b2.baseballInfo();
		
		System.out.println("static 멤버 변수 >> " + Baseball.count);
	}

}
