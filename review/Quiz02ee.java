import java.util.Scanner;

public class Quiz02ee {

	public static void main(String[] args) {

		//랜덤 정수
		int random = (int)(Math.random() * 10) + 1;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("*** 숫자를 맞추어 보세요(1~10) ***\n");
		
		//사용자 값 입력
		//사용자 값 판별
		int userValue;
		int count = 0;
		while(true) {
			//반복 횟수
			count++;
			
			System.out.print("숫자 입력: ");
			userValue = input.nextInt();
			
			if(userValue < random) {
				System.out.println("컴퓨터의 숫자가 더 큽니다.");
				continue;
			}
			else if(userValue > random) {
				System.out.println("컴퓨터의 숫자는 더 작습니다.");
				continue;
			}
			else if(userValue == random) {
				System.out.printf("\n%d번만에 정답입니다.", count);
				break;
			}
		}
		input.close();
	}

}
