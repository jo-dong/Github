// #2

/*
 * [변수]
 * 특정 값을 저장하기 위한 공간
 * 메모리 공간에 이름을 부여한 것 → 이름을 통한 접근; Reference
 * 변하는 값
 * 
 * [변수명 규칙]
 *  1) 숫자로 시작 불가 / int 1num; (X) Syntax Error(문법 에러)
 *  2) 변수명에서 사용 가능한 기호 : _와 &
 *  3) 대소문자 구분해서 사용 : int numOne; != int numone;
 *  4) 변수명으로 다른 변수명(예약어) 사용 불가 : int float; (X)
 *  5) 변수명의 길이 제한 없음
 *  6) 2, 3개의 단어를 조합할 때는 Camel Case or UnderBar(Snake case)
 *  	Camel case : int dataType;
 *  	Snake case : int data_type; 
 * 
 * [상수]
 * 변하지 않는 값
 * 기본 자료형을 사용
 * 
 * 정수형 상수 : int
 * 실수형 상수 : double
 * 
 * [접미사]
 * L : 정수형 상수L (int -> long)
 * F : 실수형 상수F (double -> float)
 */

public class Variable {

	public static void main(String[] args) {
		
		// 변수 선언		
		// 형태 : 자료형 변수명;
		int num;
		// 초기화
		num = 123456789;
		
		// 변수 선언 동시에 초기화 >> 권장
		int var = 6;
		
		System.out.println("num >> " + num);
		System.out.println("var >> " + var);
	}

}

// Ctrl + Shift + Enter : 위로 빈 줄 추가		
// Shift + Enter : 아래로 빈 줄 추가(커서가 맨 끝에 있지 않아도 됨)		
// Ctrl + D : 커서가 있는 라인 삭제 
// Ctrl + PageDown : 현재 파일에서 오른쪽에 있는 파일로 전환
// Ctrl + Alt + ↓ : 라인 복사
// Alt + ↓ : 라인 이동
		

