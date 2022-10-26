class Fruit {
	
	final int count;
	String sort;
	
	// 생성자
	public Fruit(int count) {
		this.count = count;
	}
	
//	public int getCount() {
//		return count;
//	}
//	public void setCount(int count) {
//		this.count = count;
//	}
//	public String getSort() {
//		return sort;
//	}
	public void setSort(String sort) {
		this.sort = sort;
	}

	// 멤버 메소드
	public void showInfo() {
		System.out.println(this.sort + "는 현재 " + this.count + "개 있습니다.");
	}
	
}

public class VariableFinalEx01 {

	public static void main(String[] args) {

		Fruit apple = new Fruit(5000);
		apple.setSort("사과");
		apple.showInfo();
		
		Fruit banana = new Fruit(10000);
		banana.setSort("바나나");
		banana.showInfo();
	}

}
