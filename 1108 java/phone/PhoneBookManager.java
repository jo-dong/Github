package phone;

import java.util.HashSet;
import java.util.Iterator;

public class PhoneBookManager {

	// HashSet을 이용하여 PhoneBookInfo 객체 관리
	// 이름과 연락처가 중복 저장되지 않도록 하시오.
	// 저장할 때 중복된 이름이 있다면 '이미 저장되어 있습니다.' 문구 출력
	
	HashSet<PhoneBookInfo> infoStorage = new HashSet<PhoneBookInfo>();
	Iterator<PhoneBookInfo> iter = infoStorage.iterator();
	
	// Business Rule
	// ========================= [Search] =========================
	private int search(String name) {		// return 값을 String으로 
		iter = infoStorage.iterator();
		PhoneBookInfo phoneBook;
		while(iter.hasNext()) {
			phoneBook = iter.next();
			if((phoneBook.name).equals(name)) {
				return 0;
			}
		}
		return -1;
	}
	
	// ======================= [InputData] =======================
	public void inputData() {
		System.out.println("\n데이터 입력을 시작합니다...\n");
		
		System.out.print("이름 : ");
		String name = MenuViewer.INPUT.nextLine();	// Buffer에 남아있는 enter가 인식
		System.out.print("전화번호 : ");
		String phone = MenuViewer.INPUT.nextLine();
		
		PhoneBookInfo phoneBook = new PhoneBookInfo(name, phone);
		
		int idx = search(name);
		
		if(idx == 0) {
			System.out.println("\n이미 저장되어 있습니다.\n");
		} 
		else {
			infoStorage.add(phoneBook);
			System.out.println("\n데이터 입력이 완료되었습니다.\n");
		}
	}
	
	// ====================== [SearchData] ======================
	public void searchData() {
		System.out.println("\n데이터 검색을 시작합니다...\n");
		
		System.out.print("이름 : ");
		String name = MenuViewer.INPUT.nextLine();
		
		int idx = search(name);
		
		if(idx == -1) 
			System.out.println("\n해당 데이터가 존재하지 않습니다.\n");
		else {
			for(PhoneBookInfo str : infoStorage) {
				if(str.name.equals(name)) {
					System.out.println();
					str.showPhoneInfo();
					break;
				}
			}
			System.out.println("\n데이터 검색이 완료되었습니다.\n");
		}
	}
	
	// ====================== [DeleteData] ======================
	public void deleteData() {
		System.out.println("\n데이터 삭제를 시작합니다...\n");
		
		System.out.print("이름 : ");
		String name = MenuViewer.INPUT.nextLine();
		
		int idx = search(name);
		
		if(idx == -1)
			System.out.println("\n해당 데이터는 존재하지 않습니다.\n");
		else {
			iter = infoStorage.iterator();
			PhoneBookInfo phoneBook;
			while(iter.hasNext()) {
				phoneBook = iter.next();
				if((phoneBook.name).equals(name)) {
					iter.remove();
					break;
				}
			}
			System.out.println("데이터 삭제가 완료되었습니다.\n");
		}
	}
	
	// ====================== [PrintData] ======================
	public void printData() {
		System.out.println("\n전체 데이터 개수 >> " + infoStorage.size() + "\n");
		for(PhoneBookInfo phoneBook : infoStorage) {
			phoneBook.showPhoneInfo();
			System.out.println();
		}
	}
	
}