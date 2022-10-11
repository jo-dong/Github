
class ArrayStack {
	
	int[] arr;
	int top = -1;
	int count = 0;
	
	int peek() {
		return arr[count+top];
	}

	int[] setArr(int num) {
		arr = new int[num];
		return arr;
	}
	
	void push(int num) {
		if (count < arr.length) {
			arr[count] = num;
			count++;
			System.out.println("Inserted Item : " + num);			
		} else 
			System.out.println("스택이 꽉 찼습니다! 용량 초과!");	
	}
	
	int pop() {
			count--;
		if (count < arr.length && count >= 0) {
			return arr[count];
		} else
			System.out.println("스택이 비었습니다!");
			return count;
	}
	
}

public class Quiz03J {

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
				
		System.out.println("pop 실행 : " + stack.pop());
		System.out.println("pop 실행 : " + stack.pop());
		System.out.println("pop 실행 : " + stack.pop());
		System.out.println("pop 실행 : " + stack.pop());
		System.out.println("pop 실행 : " + stack.pop());
		System.out.println("pop 실행 : " + stack.pop());
		
	}

}
