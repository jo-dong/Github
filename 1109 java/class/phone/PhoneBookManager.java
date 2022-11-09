package phone;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class PhoneBookManager {

	// [HashMap]
	// key : name, value : 객체
	// 이름이 같을 경우, '이미 저장된 이름입니다...' 출력하고 저장되지 않음
	
	private HashMap<String, PhoneBookInfo> infoStorage = new HashMap<String, PhoneBookInfo>();
	Iterator<Entry<String, PhoneBookInfo>> iter = infoStorage.entrySet().iterator();
	
	// Business Rule
	// ========================= [Search] =========================
	private String search(String name) {	
		iter = infoStorage.entrySet().iterator();
		
		while(iter.hasNext()) {
			String target = iter.next().getKey();
			if(name.equals(target)) {
				return target;	// 이름이 같은 객체의 주소를 리턴
			}
		}
		return null;
	}
	
	// ======================= [InputData] =======================
	public void inputData() {
		System.out.println("\n데이터 입력을 시작합니다...\n");
		
		System.out.print("이름 : ");
		String name = MenuViewer.INPUT.nextLine();
		System.out.print("전화번호 : ");
		String phone = MenuViewer.INPUT.nextLine();
		System.out.println();
		
		PhoneBookInfo newInfo = new PhoneBookInfo(name, phone);
		
		if(infoStorage.containsKey(name)) {
			System.out.println("이미 저장된 이름입니다...\n");
		}
		else {
			infoStorage.put(name, newInfo);
			System.out.println("데이터 입력이 완료되었습니다.\n");
		}
	}
	
	// ====================== [SearchData] ======================
	public void searchData() {
		System.out.println("\n데이터 검색을 시작합니다...\n");
		
		System.out.print("이름 : ");
		String name = MenuViewer.INPUT.nextLine();
		
		String searchName = search(name);
		
		System.out.println();
		
		if(searchName == null) {
			System.out.println("해당 데이터가 존재하지 않습니다.\n");
		}
		else {
			infoStorage.get(searchName).showPhoneInfo();
			System.out.println("\n데이터 검색이 완료되었습니다.\n");
		}
	}
	
	// ====================== [DeleteData] ======================
	public void deleteData() {
		System.out.println("\n데이터 삭제를 시작합니다...\n");
		
		System.out.print("이름 : ");
		String name = MenuViewer.INPUT.nextLine();
		
		String searchName = search(name);
		
		if(searchName == null)
			System.out.println("\n해당 데이터는 존재하지 않습니다.\n");
		else {
			infoStorage.remove(searchName);
			System.out.println("\n데이터 삭제가 완료되었습니다.\n");
		}
	}
	
	// ====================== [PrintData] ======================
	public void printData() {
		System.out.println("\n전체 데이터 개수 >> " + infoStorage.size() + "\n");
		iter = infoStorage.entrySet().iterator();
		while(iter.hasNext()) {
			iter.next().getValue().showPhoneInfo();
			System.out.println();
		}
	}
	
}