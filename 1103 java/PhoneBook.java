
import phone.MenuViewer;
import phone.PhoneBookManager;

public class PhoneBook {
	
	private static PhoneBookManager manager = new PhoneBookManager();
	
	public static void main(String[] args) throws NullPointerException {
//		MenuViewer.userNum = MenuViewer.INPUT.nextLine();
//		int userNum = MenuViewer.INPUT.nextInt();
		
		outer :
			while(true) {
			MenuViewer.showMenu();
			int userNum = MenuViewer.INPUT.nextInt();
			switch(userNum) {
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
				System.out.println("프로그램을 종료합니다.");
				MenuViewer.INPUT.close();
				break outer;
			}
		}
	}
}

