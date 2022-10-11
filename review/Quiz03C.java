import java.util.Arrays;

class ArrayStack{
	int[] arr;
	int top = -1;
	int userSet = 0;
	int popValue = 0;
	
	int peek() {
		return arr[top];
	}
	
	void setArr(int number) {
	
		this.arr = new int[number];
		top=0;
		userSet=number;
		
	}
	
	void push(int item) {
		
		if(top<userSet) {
			arr[top]=item;
			System.out.println("Inserted Item : "+ item);
			top++;
		}
		else {
			System.out.println("스택이 꽉 찼습니다! 용량 초과!");
			top = userSet-1;
		}
	}
	
	int pop() {
		
		if(top<0) {
			System.out.println("스택이 비었습니다!");
			top=0;
			popValue=-1;
		}
		else {
			popValue=arr[top];
			top--;
		}
		return popValue;

	}
}



public class Quiz03C {

	public static void main(String[] args) {
		
		ArrayStack stack = new ArrayStack();
		
		stack.setArr(5);
		
		stack.push(20);
		stack.push(15);
		stack.push(10);
		stack.push(55);
		stack.push(8);
		stack.push(5);
		
		
		System.out.println("\ntop에 있는 아이템 출력 : "+stack.peek());
		
		System.out.println("pop 실행 : "+stack.pop());
		System.out.println("pop 실행 : "+stack.pop());
		System.out.println("pop 실행 : "+stack.pop());
		System.out.println("pop 실행 : "+stack.pop());
		System.out.println("pop 실행 : "+stack.pop());
		System.out.println("pop 실행 : "+stack.pop());
		
		System.out.println(Arrays.toString(stack.arr));
	}

}
