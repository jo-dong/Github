/*
 * [enum] : 열거형
 *  : JDK 1.5부터 추가
 *  : 열거형 상수(final)
 *  : 멤버 변수는 모두 대문자로 사용
 *  : 관련 있는 상수들을 하나의 이름으로 관리하고 싶어서 사용(배열과 의미가 같다)
 *  : 첫 번째 멤버가 0부터 시작하여 1씩 자동으로 증가(0이 아닌 값으로도 시작 가능)
 *  : switch문 사용할 때 편함
 *  
 *  1) enum의 생성자는 기본적으로 private : 외부 객체 생성 불가
 *  2) enum의 member field는 기본적으로 final static : 값 변경 불가
 *  
 *  아래 코드와 비슷한 동작을 함
 */

package enumexample;

// class로 enum(열거형) 구현
class Season {
	
	// 내부에서 객체 생성
	final static Season SPRING = new Season("SPRING");
	final static Season SUMMER = new Season("SUMMER");
	final static Season FALL = new Season("FALL");
	final static Season WINTER = new Season("WINTER");
	
	// member field
	private String name;
	
	// 생성자 : private => 외부 객체 생성 불가능
	private Season(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
}

public class Ex01 {

	public static void main(String[] args) {
		
		System.out.println(Season.SPRING);
		
	}

}
