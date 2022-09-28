
public class IfEx02 {

	public static void main(String[] args) {

		// 2. 조건 2개
		int num = 5;
		
		if (num >= 5) {		
			System.out.println("조건이 true입니다.");	// 조건이 true일 때 실행되는 영역
			System.out.println("num >> " + num);		// 조건이 true일 때 실행되는 영역
		}
		else {
			System.out.println("조건이 false입니다.");	// 조건이 false일 때 실행되는 영역
		}
		
		System.out.println("실행 완료");				// if문이 끝나고 나서 실행
		
	}

}
