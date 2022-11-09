package phone;

public class PhoneBookInfo {

	String name;
	String phoneNumber;
	
	public String getName() {
		return name;
	}

	// getter, setter 추가
	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public PhoneBookInfo(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public void showPhoneInfo() {
		System.out.println("name : " + this.name);
		System.out.println("phone : " + this.phoneNumber);
	}
	
	// Overriding : 중복 검사
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof PhoneBookInfo) {
			PhoneBookInfo info = (PhoneBookInfo)obj;
			return info.name.equals(this.name);
		}
		return false;
		
	}
}