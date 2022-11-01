package staticexample;

class Product {
	int price;
	int bonusPoint;
	
	Product(int price) {
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}
}

class Tv extends Product {
	Tv() {
		super(100);
	}
	
	@Override
	public String toString() {
		return "Tv";
	}
	
}

class Computer extends Product {
	Computer() {
		super(200);
	}
	
	@Override
	public String toString() {
		return "Computer";
	}
}

class Buyer {
	int money = 1000;
	int bonusPoint = 0;
	int i = 0;
	int count = 0;
	
	String[] arr = new String[10];
	
	void buy(Product p) {
		if(money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		}
		
		money -= p.price;
		bonusPoint += p.bonusPoint;
		count += p.price;
		
		System.out.println(p + "을/를 구입하셨습니다.");
		
		arr[i++] = p.toString();
		
	}
	
	public void summary() {
		String buyList = "";
		System.out.print("구입하신 물품의 총 금액은 "+ count + "만원입니다. \n구입하신 제품은 ");
		for(int j=0; j<arr.length-1; j++) {
			if(arr[j] != null) {
				buyList += arr[j] + ", ";
			}
		}
		System.out.println(buyList + "입니다.");
	}
	
}

public class BuyerRefactoring {

	public static void main(String[] args) {

		Buyer b = new Buyer();
		
		b.buy(new Tv());
		b.buy(new Computer());
		b.buy(new Computer());
		b.buy(new Computer());
		b.buy(new Computer());
		b.buy(new Tv());
		
		System.out.println("현재 남은 돈은 " + b.money + "만원입니다.");
		System.out.println("현재 보너스 점수는 " + b.bonusPoint + "점입니다.");
		
		b.summary();
		
	}

}
