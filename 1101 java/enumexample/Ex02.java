package enumexample;

enum SeasonTwo {
	
	// [member field]
	// 	: static final => 상수화
	//  : 값 변경 불가능 => Type 변경에 안전하다
	//  : enum member field는 switch문에서 사용 가능
	
	SPRING, SUMMER, FALL, WINTER	// 자동으로 final static, 배열 형태로 관리됨 / SeasonTwo.values()로 확인 가능
	
	// 생성자 - private
//	private SeasonTwo() {}
	
}

public class Ex02 {

	public static void main(String[] args) {
		
		// 1. 객체 생성(불가능) ======================================================================
//		SeasonTwo season = new SeasonTwo();		// Error : enum은 외부 객체 생성 불가(생성자가 private)
		
		// 2. print ================================================================================
		System.out.println(SeasonTwo.SPRING); 	// 주소가 출력되지 않고 바로 문자열 자체가 출력
		System.out.println(SeasonTwo.SUMMER);	// 하지만 아직까지 SPRING, ... , WINTER = 참조 변수
		System.out.println(SeasonTwo.FALL);
		System.out.println(SeasonTwo.WINTER);
		
		// 3. ======================================================================================
		SeasonTwo spring = SeasonTwo.SPRING;			// static => 클래스명으로 접근 가능
		System.out.println("spring >> " + spring); 		// output : SPRING
														// toString이 자동으로 Overriding
		SeasonTwo spring2 = SeasonTwo.SPRING;
		if(spring == spring2)
			System.out.println("spring과 spring2는 같다.");
		else
			System.out.println("spring과 spring2는 다르다.");
		// 같다. 어차피 final이라 객체가 동일.
		
		// 4. 열거형의 클래스명 확인 ==================================================================
		System.out.println(SeasonTwo.SPRING.getDeclaringClass());
		
		// 5. 열거형 상수명 확인 ======================================================================
		System.out.println(SeasonTwo.SPRING.name());
		
		// 6. 열거형 상수 => 배열 형태로 return ========================================================
		System.out.println(SeasonTwo.values());
				// output : [Lenumexample.SeasonTwo;@5aaa6d82
				//        [ : 1차원 배열
		
		// 6-1. 향상된 for문으로 확인 =================================================================
		for(SeasonTwo s : SeasonTwo.values())
			System.out.println(s);
			// 배열 내의 contents 확인
		
		// 6-2. 열거형 상수(정수) 값 확인 =============================================================
		for(SeasonTwo s : SeasonTwo.values())
			System.out.println(s.ordinal());
		
		// 7. switch문 =============================================================================
		SeasonTwo currentSeason = SeasonTwo.FALL;
		
		switch(currentSeason) {
		case SPRING :
			System.out.println("봄");
			break;
		case SUMMER :
			System.out.println("여름");
			break;
		case FALL :
			System.out.println("가을");
			break;
		case WINTER :
			System.out.println("겨울");
			break;
		}
		
		
		
	}

}
