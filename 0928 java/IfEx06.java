
public class IfEx06 {

	public static void main(String[] args) {

		int score = 95;
		
		if (score >= 90) {
			System.out.println("90 ~ 100");
			System.out.println("학점 : A");
		}
		else if (score >= 80) {
			System.out.println("80 ~ 89");
			System.out.println("학점 : B");
		}
		else if (score >= 70) {
			System.out.println("70 ~ 79");
			System.out.println("학점 : C");
		}
		else {
			System.out.println("0 ~ 69");
			System.out.println("학점 : D");
		}
		
	}

}
