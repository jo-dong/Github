package phone;

public class PhoneBookManager {

	private final int MAX_CNT = 100;
	private PhoneBookInfo[] infoStorage = new PhoneBookInfo[this.MAX_CNT];
	private int index; 
	String name;
	String phoneNumber;

	private int search(String name){
		for (index = 0; index < infoStorage.length; index++) {
			if((infoStorage[index].name).equals(name)) 
				return index;
		}
		return MAX_CNT;
	}

	// 1. 데이터 입력
	public void inputData() {
		System.out.println("데이터 입력을 시작합니다...");
		System.out.print("이름 : ");
		String name = MenuViewer.INPUT.next();
		System.out.print("전화번호 : ");
		String phoneNumber = MenuViewer.INPUT.next();
		System.out.println("데이터 입력이 완료되었습니다.\n");

		infoStorage[index++] = new PhoneBookInfo(name, phoneNumber);

	}

	// 2. 데이터 검색
	public void searchData() {
		System.out.println("데이터 검색을 시작합니다...");
		System.out.print("이름 : ");
		String name = MenuViewer.INPUT.next();		
		
		if(search(name) == MAX_CNT) {
			System.out.println("해당하는 데이터가 존재하지 않습니다.\n");
		}
		else if(search(name) != MAX_CNT) {
			infoStorage[this.search(name)].showPhoneInfo();
			System.out.println("데이터 검색이 완료되었습니다.\n");
		}
	}
	
	// 3. 데이터 삭제
	public void deleteData() {
		System.out.println("데이터 삭제를 시작합니다...");
		System.out.print("이름 : ");
		String name = MenuViewer.INPUT.next();	
		if(search(name) == index) {
			infoStorage[search(name)].name = "";
			infoStorage[search(name)].phoneNumber = "";
			System.out.println("데이터 삭제가 완료되었습니다.\n");
		}
		else
			System.out.println("해당하는 데이터가 존재하지 않습니다.\n");
	}

}
