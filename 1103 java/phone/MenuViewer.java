package phone;

import java.util.Scanner;

public class MenuViewer {
	public static final Scanner INPUT = new Scanner(System.in);
//	static String userNum = INPUT.nextLine();
//	static int userNum = INPUT.nextInt();
	
	public static void showMenu() {
		System.out.println("선택하세요...\n"
						 + "1. 데이터 입력\n"
						 + "2. 데이터 검색\n"
						 + "3. 데이터 삭제");
		System.out.print("4. 프로그램 종료\n선택 : ");
//		userNum = INPUT.nextLine();
	}
	
}
