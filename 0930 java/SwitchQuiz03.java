import java.util.Scanner;

public class SwitchQuiz03 {

	public static void main(String[] args) {

		// 컴퓨터와 가위바위보
			// 사용자에게 가위, 바위, 보에 해당하는 정수 입력 받고
			// 컴퓨터는 랜덤 값으로 설정
		// 당신은 3입니다.
		// 컴은 1입니다.
		// 당신이 졌습니다.
		
		Scanner input = new Scanner(System.in);
		
		int userNum = 0;
		System.out.print("가위(1), 바위(2), 보(3) 중 하나를 입력 >> ");
		
		userNum = input.nextInt();	
		int ranNum = (int)(Math.random() * 3 + 1); // 1, 2, 3
				
		// 가위바위보 게임 출력
		switch (ranNum) {
		case 1 : 				// 컴퓨터 : 가위
			switch (userNum) {
			case 1 :			// user : 가위
				System.out.println("당신은 " + userNum + "입니다.");
				System.out.println("컴퓨터는 " + ranNum + "입니다.");
				System.out.println("비겼습니다.");			
				break;
			case 2 :			// user : 바위
				System.out.println("당신은 " + userNum + "입니다.");
				System.out.println("컴퓨터는 " + ranNum + "입니다.");
				System.out.println("당신이 이겼습니다.");	
				break;
			case 3 :			// user : 보
				System.out.println("당신은 " + userNum + "입니다.");
				System.out.println("컴퓨터는 " + ranNum + "입니다.");
				System.out.println("당신이 졌습니다.");	
				break;
			}
			break;
		case 2 :				// 컴퓨터 : 바위
			switch (userNum) {
			case 1 :			// user : 가위
				System.out.println("당신은 " + userNum + "입니다.");
				System.out.println("컴퓨터는 " + ranNum + "입니다.");
				System.out.println("당신이 졌습니다.");			
				break;
			case 2 :			// user : 바위
				System.out.println("당신은 " + userNum + "입니다.");
				System.out.println("컴퓨터는 " + ranNum + "입니다.");
				System.out.println("비겼습니다.");	
				break;
			case 3 :			// user : 보
				System.out.println("당신은 " + userNum + "입니다.");
				System.out.println("컴퓨터는 " + ranNum + "입니다.");
				System.out.println("당신이 이겼습니다.");	
				break;
			}
			break;
		case 3 :				// 컴퓨터 : 보
			switch (userNum) {
			case 1 :			// user : 가위
				System.out.println("당신은 " + userNum + "입니다.");
				System.out.println("컴퓨터는 " + ranNum + "입니다.");
				System.out.println("당신이 이겼습니다.");			
				break;
			case 2 :			// user : 바위
				System.out.println("당신은 " + userNum + "입니다.");
				System.out.println("컴퓨터는 " + ranNum + "입니다.");
				System.out.println("당신이 졌습니다.");	
				break;
			case 3 :			// user : 보
				System.out.println("당신은 " + userNum + "입니다.");
				System.out.println("컴퓨터는 " + ranNum + "입니다.");
				System.out.println("비겼습니다.");	
				break;
			}
			break;
		}
		
	}

}
