

class ArrayStack{
	int[] arr;
	int top = -1;
	int size;
	
	int peek() {
		return arr[top];
	}

	public ArrayStack() {
		setArr();
	}

	public void setArr() {
		for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
	}

	public void push(int value) {

		System.out.println("Inserted Item : ");
		
		if (top == arr.length-1) {
			System.out.println("스택이 꽉 찼습니다! 용량 초과!");
		}
		top += 1;
		arr[top] = value;
	}
	
	public int pop() {
		System.out.println("pop 실행 : ");
		
		if (top == -1) {
			System.out.println("스택이 비어있습니다!");
	        return -1;
	    }

	    int res = arr[top];
	    arr[top] = -1;
	    top -= -1;
	    return res;
	}
	
}

public class Quiz030 {

	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack();
		
		stack.setArr();
		
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
