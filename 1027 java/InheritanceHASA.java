
/*
 *  [멤버 수]
 *  Super(부모) class <= Sub(자식) class ((항상))
 *  
 * [Is-A 관계] - 상속 관계
 * 	- ~는 ~다.
 *  	ex1) 학생은 사람이다. (O)
 *  		=> 학생 : Sub, 사람 : Super
 *  	ex2) 사람은 학생이다. (X)
 *  
 *  [Has-A 관계] - 포함 관계
 *  - ~는 ~를 소유(포함)하고 있다.
 *  	ex1) 핸드폰은 카메라(기능)를 포함하고 있다.	(O)
 *  		=> 핸드폰 : Sub, 카메라 : Super
 *  	ex1) 카메라는 핸드폰(기능)을 포함하고 있다.	(X)
 *  
 *  	ex1) 경찰이 총을 소유하고 있다.	 (O)
 *  		=> 경찰 : Sub, 총 : Super
 *  	ex1) 총이 경찰을 소유하고 있다. (X)
 * 
 */

class Gun {
	int bullet;
	
	public Gun(int bnum) {
		if(bnum != 0)
			bullet = bnum;
		else
			bullet = 1;
	}
	
	public void shoot() {
		System.out.println("BBANG!");
		bullet--;
	}
}

class Police {
	int handcuffs;
	// Containment
	Gun pistol;		// 자료형(Class) : Gun => pistol : 참조 변수 -> Heap 영역에 생성 
	
	public Police(int bnum, int bcuff) {
		handcuffs = bcuff;
		if(bnum != 0)
			pistol = new Gun(bnum);
		else
			pistol = null;
	}
	
	public void putHandcuff() {
		System.out.println("SNAP!");
		handcuffs--;
	}
	
	public void shoot() {
		if(pistol == null)
			System.out.println("Hut BBANG!");
		else
			pistol.shoot();
	}
}

public class InheritanceHASA {

	public static void main(String[] args) {

		Police pman = new Police(1, 3);
		pman.shoot();
		pman.putHandcuff();
		System.out.println("남은 총알 수 : " + pman.pistol.bullet);
		System.out.println("남은 수갑 수 : " + pman.handcuffs);
		
	}

}
