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
		if (index == stack.length - 1) {
			index = 0;
		} else {
			index += 1;
		}
		count_10 += 1;
		stack[index] = value;
	}

	private static int pop() {
		int tmp = stack[index];
		if (count_10 == 0) {
			tmp = 0;
		} else {
			if (index == 0) {
				index = 9;
			} else {
				index -= 1;
				count_10 -= 1;
			}
		}
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
