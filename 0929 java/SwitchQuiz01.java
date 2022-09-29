import java.util.Scanner;

public class SwitchQuiz01 {

	public static void main(String[] args) {

		// 12, 1, 2  : 겨울
		// 3, 4, 5   : 봄
		// 6, 7, 8   : 여름
		// 9, 10, 11 : 가을
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("숫자 입력 : ");
		int season = input.nextInt();
		
		String seasonString = " ";
		
		switch(season) {
		case 1 :
			seasonString = "Winter";
			break;
		case 2 :
			seasonString = "Winter";
			break;
		case 3 :
			seasonString = "Spring";
			break;
		case 4 :
			seasonString = "Spring";
			break;
		case 5 :
			seasonString = "Spring";
			break;
		case 6 :
			seasonString = "Summer";
			break;
		case 7 :
			seasonString = "Summer";
			break;
		case 8 :
			seasonString = "Summer";
			break;
		case 9 :
			seasonString = "Fall";
			break;
		case 10 :
			seasonString = "Fall";
			break;
		case 11 :
			seasonString = "Fall";
			break;
		case 12 :
			seasonString = "Winter";
			break;
		default :
			seasonString = "잘못된 입력입니다.";
			break;
		}
		
		System.out.println(seasonString);
	}

}
