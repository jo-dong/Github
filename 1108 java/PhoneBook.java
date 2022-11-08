import phone.MenuViewer;
import phone.PhoneBookManager;

public class PhoneBook {

	public static void main(String[] args) {
		
		int choice;
		PhoneBookManager manager = new PhoneBookManager();

		outer : 
		while(true) {
			MenuViewer.showMenu();
			choice = MenuViewer.INPUT.nextInt();
			MenuViewer.INPUT.nextLine();	// 이걸 적어주면 PhoneBookManager에 nextLine을 사용해도 된다.
			
			switch(choice) {
			case 1 :
				manager.inputData();
				break;
			case 2 :
				manager.searchData();
				break;
			case 3 :
				manager.deleteData();
				break;
			case 4 :
				manager.printData();
				break;
			case 5 :
				System.out.println("\n프로그램을 종료합니다.");
				MenuViewer.INPUT.close();
				break outer;
			}
		}
	}
}