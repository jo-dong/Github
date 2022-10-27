// 자동 import : Ctrl + Shift + O
import area.CircleArea;
import per.CirclePerimeter;

public class Circle {

	public static void main(String[] args) {

		CircleArea area = new CircleArea(1.5);
		System.out.println("원 넓이 : " + area.getArea());
		
		CirclePerimeter per = new CirclePerimeter(1.5);
		System.out.println("원 둘레 : " + per.getPerimeter());
		
	}

}
