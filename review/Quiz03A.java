class ArrayStack {		// 같은 폴더 같은 클래스 오류
	int[] arr;
	int top = -1;
	
	int peek() {
		return arr[top];
	}
	
	void setArr(int num) {
		arr = new int[num];
	}
	
	void push (int num) {
		if (top > 3) {
			System.out.println("스택이 꽉 찼습니다! 용량 초과!");
			return;
		}
		
		top++;
		arr[top] = num;
		System.out.println("Inserted Item : " + num);
	}
	
	int pop() {
		if(top < 0) {
			System.out.println("스택이 비었습니다.");
			return top;
		}
		
		top--;
		return arr[top + 1];
	}
}

public class Quiz03A {

	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack();
		
		stack.setArr(5);
		
		stack.push(20);
		stack.push(15);
		stack.push(10);
		stack.push(55);
		stack.push(8);
		stack.push(5);
		
		System.out.println("\ntop에 있는 아이템 출력 : " + stack.peek());
		
		System.out.println("pop 실행 : " +stack.pop());
		System.out.println("pop 실행 : " +stack.pop());
		System.out.println("pop 실행 : " +stack.pop());
		System.out.println("pop 실행 : " +stack.pop());
		System.out.println("pop 실행 : " +stack.pop());
		System.out.println("pop 실행 : " +stack.pop());
	}

}