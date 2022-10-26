
class arrFruit {
	String sort;
	int count;
	
	public arrFruit(String sort, int count) {
		this.sort = sort;
		this.count = count;
	}
	
	public void fruitInfo() {
		System.out.println(this.sort + "가 " + this.count + "개 있습니다.");
	}
}

public class ArrayQuiz {

	public static void main(String[] args) {

		arrFruit[] fruit = new arrFruit[3];
		fruit[0] = new arrFruit("사과", 5);
		fruit[1] = new arrFruit("바나나", 2);
		fruit[2] = new arrFruit("망고", 3);
		
		// 1) 배열 요소(객체)의 정보 출력
		System.out.println("<< 일반 for문 >>");
		for(int i=0; i<fruit.length; i++)
			fruit[i].fruitInfo();
		
		// 2) 향상된 for문으로 출력
		System.out.println("<< 향상된 for문 >>");
		for(arrFruit f : fruit)
			f.fruitInfo();
		
	}

}
