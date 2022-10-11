import java.util.Scanner;

public class Quiz02cc {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		int random = 0;
		int userValue = 0;
		int count = 0;
		
		System.out.println("*** 숫자를 맞춰 보세요(1~10) ***\n");
		
		outer :
		while(true) {
			count++;
			random = (int)(Math.random()*10)+1;
			
			System.out.print("숫자 입력 : ");
			userValue = input.nextInt();
			
			if (random > userValue) {
				System.out.println("컴퓨터의 숫자가 더 큽니다.");
			}
			else if (random < userValue) {
				System.out.println("컴퓨터의 숫자가 더 작습니다.");
			}
			else if (random == userValue) {
				System.out.println(count + "번만에 정답입니다.");
				break outer;
			}
		}
		
	}

}
