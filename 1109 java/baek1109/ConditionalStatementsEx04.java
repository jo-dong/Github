package baek1109;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ConditionalStatementsEx04 {
	
//	public void showQuadrant() throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		
//		int x = Integer.parseInt(br.readLine());
//		int y = Integer.parseInt(br.readLine());
//		
////			if(x>0 && y>0) 
////				bw.write(String.valueOf(1));
////			else if(x<0 && y>0)
////				bw.write(String.valueOf(2));
////			else if(x<0 && y<0)
////				bw.write(String.valueOf(3));
////			else if(x>0 && y<0)
////				bw.write(String.valueOf(4));
//		
//		if(x > 0) {
//			if(y > 0)
//				bw.write(String.valueOf(1));
//			else
//				bw.write(String.valueOf(4));
//		}
//		else {
//			if(y > 0)
//				bw.write(String.valueOf(2));
//			else
//				bw.write(String.valueOf(3));
//		}
//		
//		bw.flush();
//		bw.close();
//	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		
			if(x>0 && y>0) 
				bw.write(String.valueOf(1));
			else if(x<0 && y>0)
				bw.write(String.valueOf(2));
			else if(x<0 && y<0)
				bw.write(String.valueOf(3));
			else if(x>0 && y<0)
				bw.write(String.valueOf(4));
		
//		if(x > 0) {
//			if(y > 0)
//				bw.write(String.valueOf(1));
//			else
//				bw.write(String.valueOf(4));
//		}
//		else {
//			if(y > 0)
//				bw.write(String.valueOf(2));
//			else
//				bw.write(String.valueOf(3));
//		}
		
		bw.flush();
		bw.close();
//		new ConditionalStatementsEx04().showQuadrant();
	}
}


