import java.util.Scanner;

public class IfQuiz05 {

	public static void main(String[] args) {

				// 점수를 입력 받은 후 (0 - 100) 학점 출력
				// 90 - 93 : A-, 94 - 96 : A0, 97 - 100 : A+
				// 80 - 83 : B-, 84 - 86 : B0, 87 - 89  : B+
				// 70 - 73 : C-, 74 - 76 : C0, 77 - 79  : C+
				// 나머지  : F
								
				Scanner input = new Scanner(System.in);
				
				System.out.print("점수를 입력해 주세요 >> ");
				int score = input.nextInt();
				
				if (score < 0 || score > 100) {
					System.out.println("잘못된 입력입니다.");
				}
				else if (score <= 69) {
					System.out.println("당신의 점수는 " + score + "점, 학점은 F입니다.");
				}
				else if (score <= 73) {
					System.out.println("당신의 점수는 " + score + "점, 학점은 C-입니다.");
				}
				else if (score <= 76) {
					System.out.println("당신의 점수는 " + score + "점, 학점은 C0입니다.");
				}
				else if (score <= 79) {
					System.out.println("당신의 점수는 " + score + "점, 학점은 C+입니다.");
				}
				else if (score <= 83) {
					System.out.println("당신의 점수는 " + score + "점, 학점은 B-입니다.");
				}
				else if (score <= 86) {
					System.out.println("당신의 점수는 " + score + "점, 학점은 B0입니다.");
				}
				else if (score <= 89) {
					System.out.println("당신의 점수는 " + score + "점, 학점은 B+입니다.");
				}
				else if (score <= 93) {
					System.out.println("당신의 점수는 " + score + "점, 학점은 A-입니다.");
				}
				else if (score <= 96) {
					System.out.println("당신의 점수는 " + score + "점, 학점은 A0입니다.");
				}
				else {
					System.out.println("당신의 점수는 " + score + "점, 학점은 A+입니다.");
				}
	}

}
