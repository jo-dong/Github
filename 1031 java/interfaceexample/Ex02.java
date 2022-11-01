package interfaceexample;

interface Var {
	// interface's member field
	// default 값 => public final static
	int NUM1 = 100;
	static int NUM2 = 200;
	final int NUM3 = 300;
	public static final int NUM4 = 400;
}

public class Ex02 {

	public static void main(String[] args) {

		// Create Object
//		Var v = new Var();		// interface는 객체 생성 불가능
//		Var.num2 = 2;			// Error : Var.num2 => final field
		System.out.println(Var.NUM1);
		System.out.println(Var.NUM2);
		System.out.println(Var.NUM3);
		System.out.println(Var.NUM4);
		
	}

}
