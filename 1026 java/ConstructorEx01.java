/*
 * [생성자(constructor)]
 * 
 * << 생성자를 사용하는 이유 >>
 * - 객체를 생성하면서, 멤버 변수 초기화하기 위해
 * - 객체를 생성하면서, 원하는 기능을 실행하기 위해(특정 멤버 메소드 호출)
 * 
 * << 생성자의 특징 >>
 * 
 * 생성자는 '메서드' 임 -> '메서드 오버로딩' 가능 -> 생성자를 여러 개 정의 가능
 * cf) 메서드 오버로딩
 * 		: 메서드 명이 같고, 매개변수 정보(자료형, 개수)가 다른 경우
 * 생성자는 객체 생성시, 무조건 하나의 생성자를 호출함
 * 생성자는 반환 값이 없음 -> 따라서, 반환형을 명시하지 않음
 * 생성자 명은 반드시 클래스 명과 같아야 함!
 * 
 * << 기본 생성자(default constructor) >>
 * 
 * 기본 생성자란 생성자를 명시하지 않으면, 자동으로 추가되고 실행되는 생성자
 * 생성자가 하나라도 명시되어 있다면, 기본 생성자는 실행되지 않음
 * 기본 생성자는 매개변수가 없고, 하는 일도 없이 형식상 실행됨
 */

class Cat {
	// 멤버 변수 : 인스턴스 변수 (객체 변수)
	String name;

	// 생성자
	public Cat() {
		System.out.println("생성자 실행됨");
	}
	// 생성자 오버로딩 : 매개변수가 1개, setName 기능을 하는 생성자
	public Cat(String name) {
		this.name = name;
	}
	
	// 멤버 메서드 : 인스턴스 메서드 (객체 메서드)
	// alt + shift + s -> r 단축키를 눌러 get,set 메서드를 생성
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

public class ConstructorEx01 {

	public static void main(String[] args) {
		// 인스턴스(객체) 생성
		Cat cat = new Cat("호랑이");
		
		// cat.setName("나비");
		System.out.println("고양이 이름 : " + cat.getName());
	}

}
