
public class IfEx03 {

	public static void main(String[] args) {

		// 3. 조건 3개 이상
		int num = 200;
		
		if (num < 0) {								// 조건 1 : num이 0보다 작다면
			System.out.println("0 미만");			// true라면 실행
		}
		else if (num < 100) {						// 조건 2 : 0 < num < 100이라면 
			System.out.println("0 이상 100 미만");	// true라면 실행
		}
		else {										// 조건 3 : num이 100보다 크다면
			System.out.println("100 이상");			// true라면 실행
		}
		
		System.out.println("실행 완료");
		
	}

}
