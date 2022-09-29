
public class SwitchEx03 {

	public static void main(String[] args) {

		String fruit = "사과";		// 대문자로 시작(String) = Class / "사과" = 문자열 상수
		
		switch (fruit) {
		case "사과" :
			System.out.println("사과는 오른쪽 창고에 있습니다.");
			break;
		case "배" :
			System.out.println("배는 왼쪽 창고에 있습니다.");
			break;
		default :
			System.out.println("나머지 과일은 위쪽에 있습니다.");
		}
		
	}

}
