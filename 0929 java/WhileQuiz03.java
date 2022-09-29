
public class WhileQuiz03 {

	public static void main(String[] args) {

		// 1부터 10까지 합을 구하시오
		// 1 ~ 10 누적합 : 55
		
		int i = 1;
		int sum = 0;
		
		while (i <= 10) {
			sum += i;
			i++;
		}
		System.out.println("1 ~ 10 누적합 : " + sum);
	}

}
