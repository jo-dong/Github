import java.util.Scanner;
import book.BookManager;

public class AnimalBook {

	private static BookManager manager = new BookManager();

	public static void main(String[] args) {

		String userApply;

		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.print("정보를 입력하시겠습니까? (Y/N) ...");
			userApply = input.nextLine();
			if (userApply.equals("y") || userApply.equals("Y") || userApply.equals("yes")
					|| userApply.equals("Yes") | userApply.equals("YES")) {
				manager.inputData();
			} else if (userApply.equals("n") || userApply.equals("N") || userApply.equals("no")
					|| userApply.equals("No") | userApply.equals("NO")) {
				System.out.println("정보 입력을 종료합니다.");
				manager.showBook();
				break;
			} else
				break;
			
			System.out.println();

		}
		input.close();
	}
}
