// 윤년

package baek1109;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ConditionalStatementsEx03 {

	private static int year;
	
	public void leapYear() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		year = Integer.parseInt((st.nextToken()));
		if(year >= 1 && year <= 4000) {
			if((year%4==0 && year%100!=0) || (year%400==0)) {
				bw.write(String.valueOf(1));
			}
			else
				bw.write(String.valueOf(0));
			bw.flush();
			bw.close();
		}
	}
	
	public static void main(String[] args) throws Exception {
		new ConditionalStatementsEx03().leapYear();
	}

}
