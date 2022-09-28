
/*
 * [조건문] 
 * 
 * << 조건 1개 >>
 * 
 * 	if ( 조건식 ) {
 * 		조건이 true일 때, 실행할 명령
 * 		}
 * 
 * << 조건 2개 >>
 * 
 *  if ( 조건식 ) {
 *  	조건이 true일 때, 실행할 명령
 *  	}
 *  else {
 *  	조건이 false일 때, 실행할 명령
 *  	}
 * 
 * << 조건 3개 이상 >>
 *  
 *  if ( 조건식 1 ) {
 *  	조건식 1이 true일 때, 실행할 명령
 *  	}
 *  else if ( 조건식 2 ) {
 *  	조건식 2가 true일 때, 실행할 명령
 *  	}
 *  else {
 *  	위 조건을 만족하지 않는 나머지 모두
 *  	} 
 */

public class IfEx01 {

	public static void main(String[] args) {

		// 1. 조건 1개
		int num = 5;
		
		if (num >= 5) {	// 지금처럼 if 내에 code가 하나이면 중괄호 {} 생략 가능
			System.out.println(num);		// 조건식(num > 5)이 true이면 실행됨, false면 그냥 빠져나옴
		}
		System.out.println("실행 완료");	// if문이 끝나고 나서 실행됨
	}

}
