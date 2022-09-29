
/*
 * [switch문]
 * 
 * switch (값; 정수, 변수, 식) {
 * 	case 값1(정수) :
 * 		명령문;
 * 		명령문;
 * 
 * 	case 값2(정수) :
 * 		명령문;
 * 		명령문;
 * 
 * 	default :
 * 		명령문;
 * 		명령문;
 * 	}
 */

public class SwitchEx01 {

	public static void main(String[] args) {

		int n = 3;
		
		switch (n) {
		case 1:
			System.out.println("JAVA");
			break;		// break; 가 있으면 실행 후 바로 switch문을 빠져나옴
		case 2:
			System.out.println("HTML");
			break;
		case 3:								// n = 3 : case 3을 찾아가서 실행하고 아래에 있는 모든 것을 실행하며 빠져나온다.
			System.out.println("CSS");
			break;
		default:
			System.out.println("JAVASCRIPT");
		}
		
	}

}
