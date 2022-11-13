package homework;

public class SummaryStream {

	/*
	 * [함수형 인터페이스]
	 * 	- Functional Interface는 
	 * 	  일반적으로 '구현해야 할 추상 메소드가 하나만 정의된 인터페이스'를 가리킵니다.
	 * 
	 *  package : java.util.function
	 */
	
	
	/*
	 * 1. 스트림(Stream) 이란?
	 *  - 파일이나 콘솔의 입출력을 직접 다루지 않고, 스트림이라는 흐름을 통해 다룬다.
	 *  - 스트림이란, 실제의 입력이나 출력이 표현된 데이터의 이상화된 흐름을 의미한다.
	 *  - 즉, 운영체제에 의해 생성되는 가상의 연결 고리를 의미하며, 중간 매개자 역할을 한다.
	 * 
	 *  1-1. 입출력 스트림
	 *  - 스트림은 한 방향으로만 통신할 수 있으므로, 입력과 출력을 동시에 처리할 수는 없다.
	 *  - 따라서 스트림은 사용 목적에 따라 입력 스트림과 출력 스트림으로 구분된다.
	 *  - java.io 패키지를 통해 InputStream, OutputStream 클래스를 별도로 제공.
	 *  - 즉, 자바에서의 스트림 생성이란 이러한 스트림 클래스 타입의 인스턴스를 생성한다는 의미
	 *  	
	 *  InputStream
	 *  	- abstract int read();		
	 *  		: 해당 입력 스트림으로부터 다음 바이트를 읽어들임.
	 *  	- int read(byte[] b);		
	 *  		: 해당 입력 스트림으로부터 특정 바이트를 읽어들인 후, 배열 b에 저장함.
	 *  	- int read(byte[] b, int off, int len);		
	 *  		: 해당 입력 스트림으로부터 len 바이트를 읽어들인 후, 배열 b[off]부터 저장함.
	 *  
	 *  OutputStream
	 *  	- abstract void write(int b);
	 *  		: 해당 출력 스트림에 특정 바이트를 저장함.
	 *		- void write(byte[] b);
	 *			: 배열 b의 특정 바이트를 배열 b의 길이만큼 해당 출력 스트림에 저장함.
	 *		- void write(byte[] b, int off, int len);
	 *			: 배열 b[off]부터 len 바이트를 해당 출력 스트림에 저장함.
	 *  
	 */
	
}
