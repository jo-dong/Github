
public class ArrayEx02 {

	public static void main(String[] args) {

		// 객체 배열
		// [첫 번째]
//		String[] strArr = new String[3];
//		
//		strArr[0] = new String("Java");
//		strArr[1] = new String("HTML");
//		strArr[2] = new String("CSS");
		
		// [두 번째] : 문자열 객체 생성 동시에 초기화
//		String[] strArr = new String[] {new String("Java"), new String("HTML"), new String("CSS")};
		
		// [세 번째]
//		String[] strArr = {new String("Java"), new String("HTML"), new String("CSS")};
		
		// [네 번째]
		String[] strArr = {"Java", "HTML", "CSS"};
		
		// 일반 for문
		for(int i=0; i<strArr.length; i++)
			System.out.println(strArr[i]);
		
		// 향상된 for문 : for(자료형 + 변수 : 배열명)
		for(String s : strArr) 
			System.out.println(s);
		
	}

}
