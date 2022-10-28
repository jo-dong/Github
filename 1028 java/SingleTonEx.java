
/*
 * [Singleton]
 * 	: 클래스에 생성되는 객체가 오로지 하나
 * 		- 생성자의 접근 권한 => private constructor : 외부 객체 생성 불가
 * 		- 클래스 내에서 객체 생성 : 멤버 객체
 * 		- 멤버 메소드를 통해 생성된 객체의 주소 리턴
 */

class Pattern {
	
	// 1. 생성자
	private Pattern() {
		
	}
	
	// 2. (내부) 객체 생성 - static : getter가 static이라 member를 사용하려면 static 해야함 
						// private : 외부 접근(외부 객체 생성)을 막음
	private static Pattern member = new Pattern();
	
	// 3. 멤버 메소드(getter) - static : class 명을 통해 외부에서 접근 가능하도록 함
	public static Pattern getPattern() {	// public static 반환형 getter() { return instance_variable; }
		System.out.println("member >> " + member);
		return member;
	}
	
	// 4. 멤버 변수 추가
	private int count;
	
	// 4. 멤버 메소드 추가
	// 4-1. 멤버 변수 count 값 설정
	public void setCount(int count) {
		this.count = count;
	}

	// 4-2. 멤버 변수 count 값 리턴
	public int getCount() {
		return this.count;
	}
	
}

public class SingleTonEx {

	public static void main(String[] args) {

		// 1.1 Error
		// Pattern p = new Pattern();
		
		Pattern p = Pattern.getPattern();
		System.out.println(p);
		
//		Pattern.member = (Pattern)10;		: 외부에서 접근이 안 되도록 private으로 막음
		
		p.setCount(100);
		System.out.println("count >> " + p.getCount());
		
		// ====================================================================
		
		Pattern p2 = Pattern.getPattern();
		System.out.println("count >> " + p2.getCount());
		
		
	}

}
