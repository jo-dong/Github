import java.util.Scanner;

public class Quiz021 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("숫자를 맞춰 보세요 1~10 : ");
		int idx = input.nextInt();
		int random = 0;
		int count = 0;
		random = (int)(Math.random()*10) + 1; 
		
		while(true) {
			count++;	
			
			if (idx > random) {
				System.out.println("컴퓨터의 숫자가 더 작습니다");
				System.out.print("숫자 입력 :");
				idx = input.nextInt();
			}if (idx < random) {
				System.out.println("컴퓨터의 숫자가 더 큽니다");
				System.out.print("숫자 입력 :");
				idx = input.nextInt();
			}
			if (idx == random)
				break;
			
		}				
		System.out.println("\n" + (count+1) +"만에 정답입니다");
		
		input.close();
		
	}

}
