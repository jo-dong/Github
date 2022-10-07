import java.util.Scanner;

public class P1 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int userValue = 0;
		int i = 0;
		
		System.out.print("정수 하나 입력 : ");
		userValue = input.nextInt();
		
		for(i=0; i+(userValue-i)==userValue; i++) {
			if(i < userValue && i > 0) {
				System.out.println(i+"+"+(userValue-i)+"="+userValue);
				if(i == (userValue-1))
					break;
			}
		}
	}
}
