import java.util.Scanner;

public class Quiz02G {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("숫자 입력 : ");
		int userValue = input.nextInt();
		int com = (int)(Math.random() * 10) + 1;
		int count = 1;
		
		while(true) {
			if(userValue == com)
				break;
			else if(userValue > com) {
				count++;
				System.out.println("컴퓨터의 숫자가 더 작습니다.");
				System.out.print("숫자 입력 : ");
				userValue = input.nextInt();
			} else {
				count++;
				System.out.println("컴퓨터의 숫자가 더 큽니다.");
				System.out.print("숫자 입력 : ");
				userValue = input.nextInt();
			}
		}
		
		System.out.println(count + "번만에 정답입니다.");
		
		input.close();
	}

}
