package exception;

public class Ex04 {

	public static void main(String[] args) {

		for(int i=1; i<=10; i++) {
			System.out.println(i);
			
			try {						// 예외 전가 했으니까(sleep method가 전가했음) 예외 직접 처리
				Thread.sleep(1000);		// 1000ms = 1s => 하나 출력 + 1초 쉬고
			} catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

}
