import java.util.Scanner;

public class Quiz02I {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("*** 숫자를 맞춰보세요(1~10)");
		System.out.println();
		
		int userValue = 0;
		int random = 0;
		int count = 0;
		
		while (true) {
			System.out.print("숫자 입력 : ");
			userValue = input.nextInt();
			count++;
			random = (int)(Math.random() * 10) + 1;
			
			if(userValue > random)
				System.out.println("컴퓨터가 더 작습니다.");
			else if(userValue < random)
				System.out.println("컴퓨터가 더 큽니다.");
			else
				break;
		}
		System.out.println(count + "번 만에 정답입니다.");
		
		input.close();
	}
}
