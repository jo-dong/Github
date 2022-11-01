/*
 * [interface]
 * 	: abstract class보다 엄격해진 자료형
 * 	: abstract class의 upgrade된 자료형
 * 	: 객체 생성 불가능 => 상속, 다형성으로 사용
 * 
 * 	  부모	    자식
 * 	(class) - (class) : extends
 * 	(inter) - (class) : implements
 * 	(inter) - (inter)
 * 
 *  - member field
 *  	* default 값 : public static final로 고정 => constant(상수) => 대문자
 *  
 *  - member method
 *  	* default 값 : public abstract로 고정 => 상속하려면 Overriding 필수
 *  	* (default void ~, static void ~) 사용 시 일반 method 처럼 사용 가능
 *    
 */

package interfaceexample;

interface A {}
interface B {}
interface C extends A {}
interface D extends A, B {}			// 다중 상속 허용

//interface M implements E {}		// interface는 class를 부모로 둘 수 없다!!

class E {}
class F {}
class G extends E {}
//class H extends E, F {}			// class는 Error

//class I extends A {} 				// Type이 달라서 extends는 Error
class I implements A {}				// implements를 사용해서 상속

class J extends E implements A, B {}
// 같은 Type의 Class가 먼저 오고 interface 상속을 나중에
//class K implements A extends E {}	
// 순서 바뀌면 Error


public class Ex01 {

	public static void main(String[] args) {

		
		
	}

}
