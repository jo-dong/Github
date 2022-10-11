import java.util.Scanner;

public class Quiz02dd {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int randomValue = (int) (Math.random() * 10) + 1;
		int userValue = 0;
		int count = 0;
		
		System.out.println("*** 숫자를 맞추어 보세요(1~10) ***"+"\n");
		
		while(true) {
			System.out.print("숫자 입력 : ");
			
			userValue = input.nextInt();
			count++;
			
			if(userValue > randomValue)
				System.out.println("컴퓨터의 숫자가 더 작습니다");
			else if(userValue < randomValue)
				System.out.println("컴퓨터의 숫자가 더 큽니다.");
			else if(userValue == randomValue) {
				System.out.println(count + "번만에 정답입니다.");
				break;
			}
		}
		
		input.close();
	}

}
