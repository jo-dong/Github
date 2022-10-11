import java.util.Scanner;
public class PotfolioF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc = new Scanner(System.in);
		
		System.out.print("입력 : ");
		int num = sc.nextInt();
		
		int result = 1;
		
		
		for(int i = 1; i <= num; i++) {
			result *= i;
			}
		System.out.println("출력 : " + result);
		
	}

}
