import java.io.IOException;
import java.util.Scanner;

import book.BookManagerRefactoring;

public class AnimalBookRefactoring {

	// 1. BookManager의 method를 참조변수 manager를 통해 사용 가능
	// 2. main method는 static method => static member만 사용 가능
	private static BookManagerRefactoring manager = new BookManagerRefactoring();

	public static void main(String[] args) throws IOException {	// main에도 전가 해줘야함

		String userApply;

		Scanner input = new Scanner(System.in);

		// 내 답
//		while (true) {
//			System.out.print("정보를 입력하시겠습니까? (Y/N) ...");
//			userApply = input.nextLine();
//			if (userApply.equals("y") || userApply.equals("Y") || userApply.equals("yes")
//					|| userApply.equals("Yes") | userApply.equals("YES")) {
//				manager.inputData();
//			} else if (userApply.equals("n") || userApply.equals("N") || userApply.equals("no")
//					|| userApply.equals("No") | userApply.equals("NO")) {
//				System.out.println("정보 입력을 종료합니다.\n");
//				System.out.println("<< 저장 목록 >>\n");
//				manager.showBook();
//				break;
//			} else
//				break;
//			
//			System.out.println();
//
//		}
//		input.close();		// resource 해제

		// 강사님 답
		outer :		// label : 지정된 반복문을 빠져나올 수 있다. 남용 X
		while (true) {
			System.out.print("정보 입력할까요? (Y/N) ... ");
			userApply = input.next();
			switch(userApply) {
			case "y": case "Y": case "yes": case "Yes": case "YES":
				manager.inputData();
				break;
			case "n": case "N": case "no": case "No": case "NO":
				System.out.println("정보 입력을 종료합니다.\n");
				break outer;
			default :
				System.out.println("Y/N 중 하나를 입력하세요");
			}
		}
		System.out.println("<< 저장 목록 >>\n");
		manager.showBook();
		
		input.close();		// resource 해제
	}
}
