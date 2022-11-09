// 두 수 비교하기

package baek1109;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ConditionalStatementsEx01 {	// class Main으로 바꾸기

	private static int A, B;
	
	public void condition() throws Exception  {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		if(A >= -10000 && A <= 10000 && B >= -10000 && B <= 10000) {
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			if(A < B)
				System.out.println("<");
			else if(A > B)
				System.out.println(">");
			else
				System.out.println("==");
		}
	}
	
	public static void main(String[] args) throws Exception{

		new ConditionalStatementsEx01().condition();
		
	}

}
