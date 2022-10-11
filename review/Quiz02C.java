import java.util.Scanner;

public class Quiz02C {

	public static void main(String[] args) {
		int random = 0, userValue=0, count=1;
		
		random = (int)(Math.random()*9)+1;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("숫자를 맞추어보세요(1~10)");
		System.out.println();
		
		
		while(true) {
		
			System.out.print("숫자 입력 : ");
		
			userValue=input.nextInt();
			
			if(userValue>random) {
				System.out.println("컴퓨터의 숫자가 더 작습니다.");
				count++;
			}
			else if(userValue<random) {
				System.out.println("컴퓨터의 숫자가 더 큽니다.");
				count++;
			}
			else {
				break;	
			}
			
		}
		
		System.out.println(count+"번 만에 정답입니다.");
		input.close();
	}

}
