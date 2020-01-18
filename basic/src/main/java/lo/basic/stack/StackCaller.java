package lo.basic.stack;

public class StackCaller {

	public static void main(String[] args) {
		Stack stack = new Stack();
		
		stack.push(9);
		stack.push(4);
		stack.push(8);
		stack.push(7);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.push(7);
		stack.push(8);
		System.out.println(stack.pop());
	}
}
