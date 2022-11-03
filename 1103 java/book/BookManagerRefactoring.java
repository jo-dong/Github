package book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookManagerRefactoring {
	// member field
	private final int MAX_CNT = 100;
	private AnimalInfoRefactoring[] infoStorage = new AnimalInfoRefactoring[this.MAX_CNT];
	// class AnimalInfo가 class BookManager의 자료형으로 사용되었다.
	private int index = 0;			// = 0; 안 해줘도 자동으로 0으로 초기화
	
	// method
	public void inputData() throws IOException {
		// main method에서 호출하면 Scanner 객체가 2번 생성됨(쓰레기 코드) => 해제할 때 Error
		// ★ Scanner 객체는 하나만 생성 해야함
		// Scanner input = new Scanner(System.in);		// main method에도 있음.
		
		/* 
		 * ===================== BufferdReader & BufferdWriter =====================
		 * BufferedReader == Scanner / BufferedWriter == sysout(); 의 역할
		 * 아래 선언과 같이 해줘야 하고 
		 * import java.io.BufferedReader; & import java.io.InputStreamReader; => 필수
		 * (Writer의 경우) import java.io.BufferedWriter; // import java.io.OutputStreamWriter;
		
		 * 추가적으로 .readLine()에 입력되는 값은 모두 String으로 인식
		 * 그래서 int 값을 입력하고 싶을 때에는 강제 형변환이 필요하다.
		 * ex) int age = Integer.parseInt(input.readLine());
		
		 * 또한 .readLine()에 int 값 입력의 경우 예외 처리 필수 !
		 * 대개 throws IOException 하는 편 // import java.io.IOException; 해줘야 함.
		
		 * 공백단위로 데이터를 가공하려면 .nextToken() 사용 */
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); //선언
		System.out.println("<< 정보를 입력하세요 >>");
		System.out.print("1. 이름 : ");
		String name = input.readLine();
		System.out.print("2. 나이 : ");
		int age = Integer.parseInt(input.readLine());	
		// String 값(input.readLine()) => int 값 : 강제 형 변환
		System.out.println("데이터 입력이 완료되었습니다.");
		
		// 사용자가 입력한 값 => 배열에 저장
		infoStorage[index++] = new AnimalInfoRefactoring(name, age);
		
	}
	
	public void showBook() {
		for(AnimalInfoRefactoring ai : infoStorage) {
			if(ai == null)
				break;
			else
				ai.showAnimalInfo();
		}
		System.out.println();
	}
	
}
