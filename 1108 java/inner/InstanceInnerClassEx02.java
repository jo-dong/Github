package inner;

interface Yahoo {
	// abstract method
	public void showNum();
}

class OuterTwo {
	
	// getter (Type : Inner)
	public Inner getInner(int num) {	// 지금은 setter 안 만들어서 매개변수 넣은거임 오해 X
		return new Inner(num);
	}
	
	// 내부 클래스는 같은 패키지 내에서도 이름이 같아도 됨 : 외부 클래스에 의존
	private class Inner implements Yahoo {
		// private class라 상속을 시켜서 주소를 찾아줌
		
		// instance field
		int num;	// this.num 은 얘를 가리킴
		
		// constructor
		public Inner(int num) {
			this.num = num;
			System.out.println("Inner Class의 생성자 실행 완료!");
		}
		
		// instance method
		@Override		// 부모 interface의 것을 Overriding 해줘야 사용 가능(private class라서)
		public void showNum() {
			System.out.println("Inner class의 instance field : num >> " + this.num);
		}
		
	}
	
}

public class InstanceInnerClassEx02 {

	public static void main(String[] args) {

		OuterTwo outer = new OuterTwo();
		
		Yahoo in = outer.getInner(5);		// Inner type을 return 받음
		
		in.showNum();
		
		// showNum()을 사용하기 위해
		// 1. 외부 클래스에 getter 생성하여 Inner type 받음
		// 2. 부모 interface와 상속
		// 3. abstract method 생성 => inner class에서 Overriding
		// 4. 부모 interface로 Inner 객체 생성		/ Yahoo in = outer.getInner(5);
		// 5. in.showNum();
		
	}

}
