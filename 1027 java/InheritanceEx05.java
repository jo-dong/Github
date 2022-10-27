// Java의 모든 Class는 class Object를 부모로 둔다.

class Cats extends Object {
	@Override
	public String toString() {
		return "Cat class 입니다.";
	}
}

public class InheritanceEx05 {

	public static void main(String[] args) {

		Cats cat = new Cats();
		System.out.println(4);	// output : 4 --> 근데 출력되는 건 무조건 (타입 = 문자열), because : .toString()이 생략
		System.out.println(cat);
		System.out.println(cat.toString());
		System.out.println(cat.getClass());
		System.out.println(cat.getClass().getName());
		
	}

}
