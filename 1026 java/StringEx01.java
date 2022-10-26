
public class StringEx01 {

	public static void main(String[] args) {

		String s = "안녕";
		String s2 = "안녕";
		String s3 = new String("안녕");
		String s4 = new String("안녕");
		
		if(s3.equals(s4))	// s3.equals(s4) ==> Heap 영역에 있는 객체 내의 멤버 변수 값(문자열의 시작 주소)을 비교하는 것
			// s = s2
			System.out.println("같다.");
		else
			// s != s3, s3 != s4
			System.out.println("다르다.");
		
		System.out.println("s3.equals(s4) >> " + s3.equals(s4));
		// output : true/false
		
		System.out.println();
	}

}
