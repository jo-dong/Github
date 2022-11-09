package baek1109;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ConditionalStatementsEx02 {
	
	int userNum;
	char grade;
	
	public void showScore() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		userNum = Integer.parseInt(st.nextToken());
		
		if(userNum >= 90)
			grade = 'A';
		else if(userNum >= 80)
			grade = 'B';
		else if(userNum >= 70)
			grade = 'C';
		else if(userNum >= 60)
			grade = 'D';
		else
			grade = 'F';
		
		bw.write(grade);
		bw.flush();
		bw.close();
		
	}

	public static void main(String[] args) throws Exception {
		
		new ConditionalStatementsEx02().showScore();
		
	}

}
