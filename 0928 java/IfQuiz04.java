import java.util.Scanner;

public class IfQuiz04 {

	public static void main(String[] args) {

		// 점수를 입력 받은 후 (0 - 100) 학점 출력
		// 90 - 100 : A
		// 80 - 89  : B
		// 70 - 79  : C
		// 0 - 69   : D
				
		Scanner input = new Scanner(System.in);
		
		System.out.print("점수를 입력해 주세요 >> ");
		int score = input.nextInt();
		
		if (score < 0 || score > 100) {
			System.out.println("잘못된 입력입니다.");
		}
		else if (score <= 69) {
			System.out.println("당신의 점수는 " + score + "점, 학점은 D입니다.");
		}
		else if (score <= 79) {
			System.out.println("당신의 점수는 " + score + "점, 학점은 C입니다.");
		}
		else if (score <= 89) {
			System.out.println("당신의 점수는 " + score + "점, 학점은 B입니다.");
		}
		else {
			System.out.println("당신의 점수는 " + score + "점, 학점은 A입니다.");
		}
		
	}

}
