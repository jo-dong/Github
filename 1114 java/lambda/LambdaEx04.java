package lambda;

@FunctionalInterface
interface Box {
	public String boxing();
}

class Banana {
	public Banana() {}
	
	public void buy(Box box) {			// Method buy()의 매개변수 Type : (interface)Box 
										// => buy()의 인수로 Lambda식을 바로 사용 가능
		System.out.println(box.boxing());
	}
}

public class LambdaEx04 {

	public static void main(String[] args) {

		// 1. Anonymous Class
		// 1-1. Create Object
		Banana bananaOne = new Banana();
		
		// 1-2. Anonymous Class
		bananaOne.buy(new Box() {
			@Override
			public String boxing() {
				return "\n<< Overriding Method in Anonymous Class >>\n" + "Boxing banana";
			}
		}); 
		
		// 2. Lambda Expression - Reference Value
		// 2-1. Create Object
		Banana bananaTwo = new Banana();
		// 2-2. Lambda Expression
		Box box = () -> "\n[Lambda Expression - Reference Value] \nBoxing banana";
		bananaTwo.buy(box);
		
		// 3. Lambda Expression - Argument
		// 3-1. Create Object
		Banana bananaThree = new Banana();
		// 3-2. Lambda Expression
		bananaThree.buy(() -> "\n[Lambda Expression - Argument] \nBoxing banana");
		
	}

}
