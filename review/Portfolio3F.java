
public class Portfolio3F {

	public static void main(String[] args){
		class ArrayStack{
			int[] arr;
			int top = -1;
			
			int peek() {
				return arr[top];
			}
		}
		ArrayStack stack = new ArrayStack();
		int[] setArr = new int[5];
		String[] setArr = new String[1]; 
		stack.setArr(5);
		int[][] push = new int[2][3];
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
		
		public class ArrayStack {
		    
		    private int top;
		    private int maxSize;
		    private Object[] stackArray;
		    
		    // 배열 스택 생성,  스택의 최대 크기로 생성
		    public ArrayStack(int maxSize){
		        
		        this.maxSize = maxSize;
		        this.stackArray = new Object[maxSize];
		        this.top = -1;
		    }
		    
		    // 스택이 비어있는지 체크
		    public boolean empty(){
		        return (top == -1);
		    }
		    
		    // 스택이 꽉찼는지 체크
		    public boolean full(){
		        return (top == maxSize-1);
		    }
		    
		    // 스택에 item 입력
		    public void push(Object item){
		        
		        if(full()) throw new ArrayIndexOutOfBoundsException((top+1)+">=" + maxSize);
		        
		        stackArray[++top] = item;
		    }
		    
		    // 스택의 가장 위의 데이터 반환
		    public Object peek(){
		        
		        if(empty()) throw new ArrayIndexOutOfBoundsException(top);
		        
		        return stackArray[top];
		    }
		    
		    // 스택의 가장 위의 데이터 제거
		    public Object pop(){
		        
		        Object item = peek();
		        
		        top--;
		        
		        return item;
		    }

		}
	}

}
