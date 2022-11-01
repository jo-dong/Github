package stringexample;

public class Ex04 {

	public static void main(String[] args) {

		String one = "";		// one => 빈 문자열 : 문자열이긴 함(길이 = 0)
		// "" : constant 영역에 만들어지고 주소를 가짐.
		String two = null;		// two => 문자열 없음
		// null : 참조하는 객체가 없음, 찾아갈 주소가 없음
		
		System.out.println("one >> " + one);
		System.out.println("two >> " + two);
		
		// [빈 문자열 확인 1] ==================================================
		// : length() method - 문자열의 길이
		System.out.println("one : 빈 문자열 길이 >> " + one.length());
		// null은 길이가 없어서 Error : NullPointerException
//		System.out.println("two : null의 길이 >> " + two.length()); 
		// "Hello"를 JVM이 자동으로 String으로 인식해서 . 사용 가능
		System.out.println("cf) Hello 문자열 길이 >> " + "Hello".length());
		
		// [빈 문자열 확인 2] ==================================================
		// : isEmpty() method /	Java 6 이후 추가 - 문자열의 길이가 0 => return true
		// : "", " " 다르다.
		System.out.println("one.isEmpty() >> " + one.isEmpty()); // true
		// Error : NullPointerException
//		System.out.println("two.isEmpty() >> " + two.isEmpty());
		System.out.println("공백.isEmpty() >> " + " ".isEmpty()); // false
		System.out.println("Hello.isEmpty() >> " + "Hello".isEmpty()); // false
		
		// [빈 문자열 확인 3] ==================================================
		// : isBlank() method /	Java 11 이후 추가 - 빈 문자열 + 공백 => return true
		// "", " "(white space) 같게 취급
		System.out.println("공백.isBlank() >> " + " ".isBlank()); // true
		System.out.println("여러 공백.isBlank() >> " + "      ".isBlank()); // true
		System.out.println("one.isBlank() >> " + one.isBlank()); // true
		
		// [빈 문자열 확인 4] ==================================================
		// : equals() method
		System.out.println("one.equals() >> " + one.equals(""));	// true
		System.out.println("one.equals() >> " + one.equals(" "));	// false
		// Error : NullPointerException
//		System.out.println("two.equals() >> " + two.equals(""));
		// Error : NullPointerException
//		System.out.println("two.equals() >> " + two.equals(null));
		
		
	}

}
