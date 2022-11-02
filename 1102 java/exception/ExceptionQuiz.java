package exception;

import java.util.Scanner;

class NameLengthException extends Exception {
	String userName;

	public NameLengthException(String userName) {
		super("잘못 입력된 이름 : ");
		this.userName = userName;
	}

	public String wrongShowName() {
		return(this.userName);
	}

}

public class ExceptionQuiz {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.print("이름 입력 : ");
		String userName = input.nextLine();

		while (userName.length() < 2) {
			try {
				throw new NameLengthException(userName);
			} catch (NameLengthException e) {
//				System.out.println(e.getMessage() + e.wrongShowName());
				System.out.println(e.getMessage().concat(e.wrongShowName()));
				System.out.print("이름 입력 : ");
				userName = input.nextLine();
			}
			if (userName.length() >= 2) {
				System.out.println("입력받은 이름 : " + userName);
				System.out.print("=== 시스템 종료 ===");
				break;
			}
		}

		input.close();

	}

}
