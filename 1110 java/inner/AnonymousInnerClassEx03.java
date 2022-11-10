package inner;

interface Box {
	public void boxing();
}

class Banana {
	// constructor
	public Banana() {
		System.out.println("[Banana] - 멸종 위기");
	}
	
	// instance method
	public void buy(Box box) {	// interface Box의 자식들을 parameter로 사용하겠다
		box.boxing();
	}
}

public class AnonymousInnerClassEx03 {

	public static void main(String[] args) {

		Banana banana = new Banana();
		banana.buy(new Box() {			// buy() 안에는 Box의 자식이 와야하기 때문에
			@Override					// parameter 자리에 Anonymous Class가 옴
			public void boxing() {
				System.out.println("바나나 포장");
			}
		}); 		
		
	}

}
