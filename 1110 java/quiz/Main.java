import item.ItemBusinessRule;
import item.ItemView;

public class Main {

	public static void main(String[] args) {

		int choice;
		ItemBusinessRule ibr = new ItemBusinessRule();
		
		outer :
		while(true) {
			ItemView.showMenu();
			choice = ItemView.INPUT.nextInt();
			
			switch(choice) {
			case 1 :
				ibr.save();
				break;
			case 2 :
				ibr.find();
				break;
			case 3 :
				ibr.update();
				break;
			case 4 :
				ibr.delete();
				break;
			case 5 :
				ibr.findAll();
				break;
			case 6 :
				ibr.clearStore();
				break;
			case 7 :
				System.out.println("\n프로그램을 종료합니다.");
				ItemView.INPUT.close();
				break outer;
			}
		}
		
	}

}
