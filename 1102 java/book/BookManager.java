package book;

import java.util.Scanner;

public class BookManager {
	// member field
	private final int MAX_CNT = 100;
	private AnimalInfo[] infoStorage = new AnimalInfo[this.MAX_CNT];
	private int index = 0;
	
	String animalName;
	int animalAge;
	
	// method
	public void inputData() {
		Scanner input = new Scanner(System.in);
		System.out.println("<< 정보를 입력하세요 >>");
		System.out.print("1. 이름 : ");
		animalName = input.nextLine();
		System.out.print("2. 나이 : ");
		animalAge = input.nextInt();
		System.out.println("데이터 입력이 완료되었습니다.");
		
		infoStorage[index++] = new AnimalInfo(animalName, animalAge);
		
	}
	
	public void showBook() {
		System.out.println("\n<< 저장 목록 >>");
		for(index=0; index<infoStorage.length; index++) {
			if(infoStorage[index] == null)
				break;
			else
				infoStorage[index].showAnimalInfo();
		}
		System.out.println();
	}
	
}
