
/*
 * for 문을 사용하여, 2단을 출력
 */

public class ForEx02 {

	public static void main(String[] args) {

//		int idx = 1;
		
		for (int idx = 1; idx < 10; idx++) {
			System.out.println("2 * " + idx + " = " + (2 * idx));
		}
//		System.out.println("idx >> " + idx);
		// -> Error : for 문 안에 변수 idx를 선언(idx:지역변수)
		// for문이 끝나고 나면 변수 idx는 사라진다.
	}

}
