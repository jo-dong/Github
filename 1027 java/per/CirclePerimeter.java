package per;
// class 명이 같아서 나는 Error를 해결하는 방법 
//	: 1. class 명 변경  2. package 경로 다르게
public class CirclePerimeter {		
	double rad;
	final double PI;
	
	public CirclePerimeter(double r) {
		rad = r;
		PI = 3.14;
	}
	public double getPerimeter() {
		return (rad * 2) * PI;
	}
}

//public class CirclePerimeter {
//
//	public static void main(String[] args) {
//
//		Circle c = new Circle(1.5);
//		System.out.println("반지름이 1.5인 원의 둘레 : " + c.getPerimeter());
//		
//	}
//
//}
