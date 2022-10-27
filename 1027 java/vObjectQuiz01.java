
class Caculator {
	int firstNum;
	int secondNum;
	
	public Caculator(int firstNum, int secondNum) {
		this.firstNum = firstNum;
		this.secondNum = secondNum;
	}
	
	public void add() {
		System.out.println("덧셈 결과 >> " + (this.firstNum + this.secondNum));
	}
	public void sub() {
		System.out.println("뺄셈 결과 >> " + (this.firstNum - this.secondNum));
	}
	public void mul() {
		System.out.println("곱셈 결과 >> " + (this.firstNum * this.secondNum));
	}
	public void div() {
		if(this.secondNum == 0)
			System.out.println("분모가 0으로 계산 불능입니다.");
		else
			System.out.println("나눗셈 결과 >> " + (this.firstNum / this.secondNum));
	}
}

public class vObjectQuiz01 {

	public static void main(String[] args) {

		System.out.println("-- 첫 번째 계산 --");
		Caculator firstCaculator = new Caculator(5, 2);
		firstCaculator.add();
		firstCaculator.sub();
		firstCaculator.mul();
		firstCaculator.div();
		
		System.out.println("\n-- 두 번째 계산 --");
		Caculator secondCaculator = new Caculator(7, 0);
		secondCaculator.add();
		secondCaculator.div();
		
//		System.out.println("\n-- 세 번째 계산 --");
//		Caculator thirdCaculator = new Caculator(15, 3);
//		thirdCaculator.add();
//		thirdCaculator.sub();
//		thirdCaculator.mul();
//		thirdCaculator.div();
		
	}

}
