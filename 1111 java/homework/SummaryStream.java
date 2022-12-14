package homework;

public class SummaryStream {

	/*
	 * [함수형 인터페이스]
	 * 	- Functional Interface는 
	 * 	일반적으로 '구현해야 할 추상 메소드가 하나만 정의된 인터페이스'를 가리킵니다.
	 */
	
	
	/*
	 * 1. 스트림(Stream) 이란?

  ㅇ [데이터 관점]
     	- 일반적으로, 데이터,패킷,비트 등의 일련의 연속성을 갖는 흐름을 의미
        	. 음성,영상,텍스트 등의 작은 데이터 조각들이 하나의 줄기를 이루며,
        	. 순서대로 물 흐르듯이 전송되는 데이터 열(列)

  ㅇ [프로세스 관점]
     	- 원격 호스트 상호간 또는 동일 호스트 내 프로세스 또는 장치 상호 간의 통신에서,
     	- 큐에 의한 메세지 전달방식 등을 이용한,
     	- 가상 연결 통로 또는 이를 구현한 소프트웨어 모듈
     	
  ㅇ 스트림 사용 이유
     	- 물리 디스크상의 파일,장치들을 통일된 방식으로 다루기 위한 가상적인 개념
        	. 따라서, 스트림은 어디서 나왔는지 어디로 가는지 신경을 쓸 필요없이,
        	. 자유롭게, 어떤 장치,프로세스,파일들과 연결될 수 있게 하므로써,
        	. 프로그래머에게 많은 편리성 줌

  ㅇ 스트림 처리 상의 특징
     	- 장치 독립적 임
        	. 장치든 파일이든 프로세스이든 상관없음 (어떤 것과도 연결될 수 있음)
     	- 버퍼 사용
        	. 대부분, 스트림이 버퍼라는 임시 저장 공간을 갖고 있어서, 
        	. 일정량을 모아두었다가, 시스템 효율을 고려하여 큰 데이터 덩어리 씩 처리하게 됨
        	. 주로, CPU와 입출력 장치 간의 속도 차이 때문에 버퍼를 경유하게 함

  ㅇ 만일, 
     	- 파일,디바이스 등을 읽으려면,
        	. 운영체제 커널에게, 이곳에 스트림을 연결토록, 시스템콜로써 요청하게 됨
     	- 장치 내 또는 네트워크 양단 간의, 프로세스 간에도, 
        	. 스트림(파이프)로써 연결이 가능함
	 */
	
}
