
public class WhileEx02 {

	public static void main(String[] args) {

		// 반복문 while을 사용하여 1 ~ 10까지 출력
		// [출력 형태]
		// 1 2 3 4 5 6 7 8 9 10
		
		int num = 1;
		
		while (num <= 10) {
			System.out.print(num + " ");
			num++;
		}
		System.out.print("\n");
		System.out.println("프로그램 종료");
	}

}
