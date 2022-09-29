import java.util.Scanner;

public class SwitchQuiz02 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		System.out.print("정수 2개를 입력하시오 >> ");
		int inputNum1 = input.nextInt();
		int inputNum2 = input.nextInt();
		
		System.out.print("사칙연산(+, -, *, /) 중 하나를 입력하시오 >> ");
		String oprtr = input.next();
		
		switch (oprtr) {
		case "+" :
			System.out.println(inputNum1 + " + " + inputNum2 + " = " + ((int)(inputNum1) + (int)inputNum2));
			break;
		case "-" :
			System.out.println(inputNum1 + " - " + inputNum2 + " = " + ((int)(inputNum1) - (int)inputNum2));
			break;
		case "*" :
			System.out.println(inputNum1 + " * " + inputNum2 + " = " + ((int)(inputNum1) * (int)inputNum2));
			break;
		case "/" :
			System.out.println(inputNum1 + " / " + inputNum2 + " = " + ((int)(inputNum1) / (int)inputNum2));
			break;
		default :
			System.out.println("잘못된 사칙연산 기호를 입력하셨습니다");
		}
		
	}

}
