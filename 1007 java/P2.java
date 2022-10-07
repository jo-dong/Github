
public class P2 {

	public static void main(String[] args) {

		int jumsu[] = {90, 80, 50, 70, 65, 90, 100, 43, 55, 87};
		int idx = 0;
		
		while(idx < jumsu.length) {
			System.out.print(jumsu[idx] + " 점 : ");
			for(int i=0; i<jumsu[idx]/10; i++) {
				System.out.print("■ ");
			}
			System.out.println();
			idx++;
		}
	}
}
