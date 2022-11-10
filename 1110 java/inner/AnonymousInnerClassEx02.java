package inner;

interface Space {
	void youKnow();		// abstract method - 미완성 메소드
}

class SubSpace implements Space {
	@Override
	public void youKnow() {
		System.out.println("우주에 대해 아는 것이 있나요?");
	}
}

public class AnonymousInnerClassEx02 {

	public static void main(String[] args) {

		// 1. SubSpace 객체 생성
		Space spaceOne = new SubSpace();	// polymorphism
		spaceOne.youKnow();
		
		// 2. 근데 상속하고 Overriding 하는 게 귀찮음 => Anonymous Class => 일회용
		Space spaceTwo = new Space() {	// Space는 interface라서 객체 생성이 안되지만
			@Override					// Anonymous class로 상속하는 척/오버라이딩을 하고 사용 가능
			public void youKnow() {
				System.out.println("I'm Anonymous Class");
			}
		};
		spaceTwo.youKnow();
		
	}

}
