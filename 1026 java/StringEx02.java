
public class StringEx02 {

	public static void main(String[] args) {

		// 기본 자료형 : primitive type
		// 참조 자료형 : reference type
		int[] arr = new int[] {2, 4};
		
		int one = 10;
		int two = new Integer(10);	// Class의 형변환. 아랫줄과 같은 의미	// Auto unboxing(참조형 -> 기본형)
		int three = (int)new Integer(10);									// unboxing
		
		Integer four = new Integer(10);
		Integer five = 10;					// Auto boxing(기본형 -> 참조형)
		Integer six = (Integer)10;			// boxing
		
		if(one == four)
			System.out.println("Same");
		else
			System.out.println("diff");
		
		if(four == five)
			System.out.println("Same");
		else
			System.out.println("diff");
	}

}
