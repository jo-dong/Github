class ArrayStack{
	int[] arr;
	int top = -1;
	int count = 0;
	int num = 0;
	
	int peek() {
		top = num-1;
		return arr[top];
	}

	public void setArr(int num) {
		this.num = num;
		arr = new int[num];
	}
	
	public void push(int insertNum) {
		count++;
		if(num < count) 
			System.out.println("스택이 꽉 찼습니다! 용량 초과!");
		else {
			arr[count-1] = insertNum;
			System.out.println("Inserted Item " + insertNum);
//			System.out.println(count);
		}
	}
	
	public int pop() {
		if(num < 0) {
			System.out.println("스택이 비었습니다!");
		}
		return arr[--num];
	}
}

public class Quiz03dd {
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
