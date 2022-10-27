package area;

// class에는 default, public 두 가지의 접근 권한 제어자만 있다.
// public class는 파일명과 같은 class에만 부여 가능
public class CircleArea {
	double rad;
	final double PI;
	
	public CircleArea(double r) {
		rad = r;
		PI = 3.14;
	}
	public double getArea() {
		return (rad * rad) * PI;
	}
}

//public class CircleArea {
//
//	public static void main(String[] args) {
//
//		Circle c = new Circle(1.5);
//		System.out.println("반지름이 1.5인 원의 넓이 : " + c.getArea());
//		
//	}
//
//}
