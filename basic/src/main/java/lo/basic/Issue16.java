package lo.basic;

import java.util.Arrays;

public class Issue16 {

	static int[] stack = new int[10];
	static int index = 0;
	static int count_10 = 0;

	public static void main(String[] args) {
		push(9);
		push(4);
		push(8);
		push(7);
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		push(7);
		push(8);
		System.out.println(pop());
	}

	private static void push(int value) {
		index += 1;
		stack[index] = value;
		while (index >= stack.length - 1) {
			int[] tmp = stack.clone();
			stack = new int[stack.length + 10];
			for (int i= 0; i < tmp.length;i++) {
				stack[i]=tmp[i];
			}
		}
			
	}

	private static int pop() {
		int tmp = stack[index];
		index -= 1;
		return tmp;
	}

	private static void allResetToZero() {
		for (int i = 0; i < stack.length; i++) {
			stack[i] = 0;
		}
		index = 0;
	}

	private static void printStack() {
		System.out.println(Arrays.toString(stack));
	}
}
