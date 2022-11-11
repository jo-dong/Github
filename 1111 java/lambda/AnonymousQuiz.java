package lambda;

@FunctionalInterface
interface Mood {
	String howAreYouFeeling(String feel);
}

// [문제 1] ================================================
// Person 클래스 정의
// : Person class는 Mood interface를 상속 받는다.
class Person implements Mood {
	@Override
	public String howAreYouFeeling(String feel) {
		return feel;
	}
}

public class AnonymousQuiz {
	
	public static void main(String[] args) {

		// [문제 2] ========================================
		// 객체 생성
		Mood instance = new Person();
		String one = instance.howAreYouFeeling("똑같아!");
		System.out.println("[문제 2] 오늘 기분 : " + one);
		
		// [문제 3-1] ======================================
		// 익명 클래스로 구현
		// howAreYouFeeling() 메소드의 인수 : "괜찮아~"
		Mood anonymous = new Mood() {
			@Override
			public String howAreYouFeeling(String feel) {
				return feel;
			}
		};
		// 출력
		String two = anonymous.howAreYouFeeling("괜찮아~");
		System.out.println("\n[문제 3-1] 난 익명 클래스야~ 내 기분은... " + two);
		
		// [문제 3-1-1] ======================================
		// Lambda 표현식으로 구현
		Mood lambda = (feel) -> feel;
		String three = lambda.howAreYouFeeling("괜찮아~");
		System.out.println("\n[문제 3-1-1] 난 Lambda 표현식이야~ 내 기분은... " + three);
		
		// [문제 3-2] ======================================
		// System.out.println() 메소드 내 익명 클래스 구현
		// howAreYouFeeling() 메소드의 인수 : "신기해"
		System.out.println("\n[문제 3-2] 난 바로 사용되었어~ 내 기분은... " + new Mood() {
			@Override
			public String howAreYouFeeling(String feel) {
				return feel;
			}
		}.howAreYouFeeling("신기해"));
						
		// [문제 3-2-1] ======================================
		System.out.println("\n[문제 3-1-1] 난 Lambda 표현식이야~ 내 기분은... " 
							+ lambda.howAreYouFeeling("괜찮아~"));
		
		System.out.println("\n[문제 3-1-1] 난 Lambda 표현식이야~ 내 기분은... " 
		+ (lambda = feel -> feel).howAreYouFeeling("괜찮아"));
		
	}
}