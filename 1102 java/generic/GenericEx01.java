package generic;

class Apple {
	@Override
	public String toString() {
		return "사과는 맛있다.";
	}
}

class Banana {
	@Override
	public String toString() {
		return "바나나는 멸종 위기이다.";
	}
}

class InstanceType {
	int count;
	/*
	 * [Generic]
	 * 	: data type을 일반화(generalize)
	 *  : compile 할 때 type이 결정됨 
	 *  	=> compiler : 번역(binary), syntax 검사, Type 검사
	 */
	
//	public void showInstanceType(Apple apple) {			// 이렇게 하면 Apple만 들어갈 수 있는데
														// 다른 것도 넣고 싶다 => Generic : class, method 둘 다 가능
	public <Fruit> void showInstanceType(Fruit type) {	// Fruit가 Type이 됨.
		System.out.println("type >> " + type);		
		count++;
	}
	
	public void showCount() {
		System.out.println("count >> " + this.count);
	}
	
}

public class GenericEx01 {

	public static void main(String[] args) {

		Apple apple = new Apple();
		Banana banana = new Banana();
		
		InstanceType in = new InstanceType();
		in.showInstanceType(apple);		// apple = 참조 변수 : 주소 출력
		in.showCount();
		
		in.showInstanceType(banana);
		in.showCount();
		
	}

}
