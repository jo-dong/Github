package stringexample;

public class Ex03 {
	static String con;			// con => Heap(멤버 변수) : null
	
	public static void main(String[] args) {

		String[] str = {"one", "two", "three", "four"};
//		String con;				// con => stack(지역 변수) : 초기화 안하면 쓰레기 값
		
		System.out.println(con + str[0]);
		
	}

}
