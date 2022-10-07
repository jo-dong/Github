import java.util.Scanner;

public class P4 {

	public static void main(String[] args) {

		// 사용자에게 금액을 입력 받아 해당되는 단위의 개수 출력
		Scanner input = new Scanner(System.in);

		int userValue = 0;
		int tenThousands = 0;
		int fiveThousands = 0;
		int oneThousand = 0;
		int fiveHundreds = 0;
		int oneHundred = 0;
		int fifty = 0;
		int ten = 0;
		
		System.out.print("금액 입력 : ");
		userValue = input.nextInt();
		System.out.println("◈화폐 단위◈");
		
		// 10000
		tenThousands = userValue/10000;
		System.out.println("10000원 : " + tenThousands + "개");
		
		// 5000
		fiveThousands = (userValue%10000)/5000;
		System.out.println("5000원 : " + fiveThousands + "개");
		
		// 1000
		oneThousand = (userValue%10000)/1000;
		if (oneThousand > 5) 	
			System.out.println("1000원 : " + (oneThousand-5) + "개");
		else
			System.out.println("1000원 : " + oneThousand + "개");
			
		// 500
		fiveHundreds = (userValue%1000)/500;
		System.out.println("500원 : " + fiveHundreds + "개");
		
		// 100
		oneHundred = (userValue%1000)/100;
		if(oneHundred > 5) 
			System.out.println("100원 : " + (oneHundred-5) + "개");
		else
			System.out.println("100원 : " + oneHundred + "개");
		
		// 50
		fifty = (userValue%100)/50;
		System.out.println("50원 : " + fifty + "개");
		
		// 10
		ten = (userValue%100)/10;
		if(ten > 5) {
			System.out.println("10원 : " + (ten-5) + "개");
		}
		else
			System.out.println("10원 : " + ten + "개");
	}

}
