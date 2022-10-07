
public class P3 {

	public static void main(String[] args) {

		// 1 ~ 9 사이의 중복되지 않는 숫자로 이루어진
		// 3자리의 숫자를 만드시오
		int random1 = (int)(Math.random()*9)+1;
		int random2 = (int)(Math.random()*9)+1;
		int random3 = (int)(Math.random()*9)+1;
		
		System.out.print(random1);
		
		while(random3 != random2) {
			if(random3 != random2) {
				while(random2 != random1) {
					if(random2 != random1) {
						System.out.print(random2);
					}
					break;
				}
				System.out.print(random3);
			}
			break;
		}
	}
}
