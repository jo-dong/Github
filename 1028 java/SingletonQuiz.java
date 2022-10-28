
class User {
	private String name;
	
	public User(String name) {
		this.name = name;
	}
	
	public void print() {
		Printer printer = Printer.getPrinter();
		printer.print(this.name + 
				" print using " + 
				printer.toString() + ".");
	}
}

class Printer {
	private Printer() {}

	private static Printer printer = null;
	
	public static Printer getPrinter() {
		if(printer == null) {
			printer = new Printer();
		}
		return printer;
	}
	
	public void print(String print) {
		System.out.println(print);
	}
	
	@Override
	public String toString() {
		return "home." + super.toString();
	}
	
}

public class SingletonQuiz {

	public static void main(String[] args) {

		User[] user = new User[5];
		
		for(int i=0; i<user.length; i++) {
			user[i] = new User((i + 1) + "-user");
			user[i].print();
		}
		
	}

}
