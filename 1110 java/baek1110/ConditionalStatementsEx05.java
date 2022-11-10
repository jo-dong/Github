package baek1110;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ConditionalStatementsEx05 {

	public static void main(String[] args) throws Exception, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int H = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		if(M < 45) {
			H--;
			M = M + 15;
			if(H < 0)
				H = 23;
			bw.write(H + " " + M);
		}
		else
			bw.write(H + " " + (M - 45));
		
		bw.flush();
		bw.close();
		
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//      StringTokenizer st = new StringTokenizer(br.readLine());
//      int h = Integer.parseInt(st.nextToken());
//      int m = Integer.parseInt(st.nextToken());
//      m -= 45;
//      if (m < 0) {
//          h--;
//          m += 60;
//      }
//      if (h < 0) h = 23;
//      System.out.print(h + " " + m);
		
	}

}
